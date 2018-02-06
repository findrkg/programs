package mycode.dsalgo;

public class Trie {

	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode node = root;
		for(int i=0; i < word.length(); i++) {
			char currentCh = word.charAt(i);
			if(!node.containsKey(currentCh)) {
				node.put(currentCh, new TrieNode());
			}
			node = node.get(currentCh);
		}
		node.setEnd();
	}

	// search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for(int i=0; i < word.length(); i++) {
			char currentCh = word.charAt(i);
			if(node.containsKey(currentCh)) {
				node = node.get(currentCh);
			}
			else {
				return null;
			}			
		}
		return node;
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode node = searchPrefix(word);
    	return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode node = searchPrefix(prefix);
    	return node != null;    	
    }

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("raj");
		trie.insert("kishor");
		trie.insert("gupta");
		
		System.out.println("Found the word : "+trie.startsWith("ra"));
	}

}
// R-way Trie
class TrieNode {
	// R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    
    public TrieNode get(char ch) {
    	return links[ch-'a'];
    }
    
    public void put(char ch, TrieNode node) {
    	links[ch-'a'] = node;
    }
    
    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}