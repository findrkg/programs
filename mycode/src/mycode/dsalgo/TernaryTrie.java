package mycode.dsalgo;

public class TernaryTrie {

	TernaryTrieNode root;

	public TernaryTrie() {
		root = new TernaryTrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		if(word != null && !word.isEmpty()) {
			insert(word, 0, root);
		}
	}

	public TernaryTrieNode insert(String word, int index, TernaryTrieNode node) {
		char ch = word.charAt(index);
		if(node == null) node = new TernaryTrieNode(ch);
		if(ch < node.value) node.left = insert(word, index, node.left);
		else if(ch > node.value) node.right = insert(word, index, node.right);
		else if(index < word.length() -1) node.mid = insert(word, index+1, node.mid);
		else node.isEnd = true;
		return node;
	}

	 // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        return search(word, 0, root);
    }

	public boolean search(String word, int index, TernaryTrieNode node) {
		char ch = word.charAt(index);
		if(node == null) return false;
		if(ch < node.value) return search(word, index, node.left);
		else if(ch > node.value) return search(word, index, node.right);
		else if(index < word.length() -1) return search(word, index+1, node.mid);
		return node.isEnd;
	}

	// that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) return false;
        return startsWith(prefix, 0, root);
    }
    
    private boolean startsWith(String prefix, int index, TernaryTrieNode node) {
        if (node == null) return false;
        char ch = prefix.charAt(index);
        if (ch < node.value) return startsWith(prefix, index, node.left);
        if (ch > node.value) return startsWith(prefix, index, node.right);
        if (index == prefix.length() - 1) return true;
        return startsWith(prefix, index + 1, node.mid);
    }

	public static void main(String[] args) {
		TernaryTrie trie = new TernaryTrie();
		trie.insert("raj");
		trie.insert("kishor");
		trie.insert("gupta");
		
		System.out.println("Found the word : "+trie.search("raj"));
	}

}

class TernaryTrieNode {
	char value;
    boolean isEnd;
    TernaryTrieNode left, mid, right;
    
    TernaryTrieNode() {
    	// do nothing
    }
    
    TernaryTrieNode(char ch) {
    	this.value = ch;
    }
}