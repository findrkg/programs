package mycode.dsalgo;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "azced";
        String str2 = "abcdef";
        EditDistance editDistance = new EditDistance();
        int result = editDistance.dynamicEditDistance(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
	}

	/**
     * Uses bottom up DP to find the edit distance
     */
    public int dynamicEditDistance(char[] str1, char[] str2){
        int distanceTable [][] = new int[str1.length+1][str2.length+1];
        
        for(int i=0; i < distanceTable [0].length; i++){
            distanceTable [0][i] = i;
        }
        
        for(int i=0; i < distanceTable .length; i++){
            distanceTable [i][0] = i;
        }
        
        for(int i=1;i <=str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    distanceTable [i][j] = distanceTable [i-1][j-1];
                }else{
                    distanceTable [i][j] = 1 + min(distanceTable [i-1][j-1], distanceTable [i-1][j], distanceTable [i][j-1]);
                }
            }
        }
        return distanceTable [str1.length][str2.length];        
    }
    
    private int min(int a, int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
}
