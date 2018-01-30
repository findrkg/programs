package mycode.dsalgo;

public class SetMatrixZeroes {

	public static void main(String args[] ){
        
        int[][] mat = {
        		{1, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1}};
                 
        System.out.println("Input Matrix :");
        printMatrix(mat);
             
        modifyMatrix(mat);
             
        System.out.println("Matrix After Modification :");
        printMatrix(mat);
	}
	
	public static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i ++){
            for (int j = 0; j < mat[0].length; j ++){
                System.out.print( mat[i][j]+" ");
            }
            System.out.println("");
        }
	}
	
	public static void modifyMatrix(int[][] mat) {
		boolean row_flag = false;
		boolean col_flag = false;
		
		for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if(i == 0 && mat[i][j] == 0) {
                	row_flag = true;                	
                }
                
                if(j == 0 && mat[i][j] == 0) {
                	col_flag = true;                	
                }

                if(mat[i][j] == 0) {                	
                	mat[i][0] = 0;
                	mat[0][j] = 0;
                }
            }
        }
		
		for (int i = 1; i < mat.length; i ++){
            for (int j = 1; j < mat[0].length; j ++){
                if(mat[0][j] == 0 || mat[i][0] == 0) {
                	mat[i][j] = 0;               	
                }
            }
		}
		
		if(row_flag) {
	        for (int i = 1; i < mat[0].length; i ++){
	            mat[0][i] = 0;               	
	        }			
		}

		if(col_flag) {
	        for (int j = 1; j < mat.length; j ++){
	            mat[j][0] = 0;               	
	        }			
		}
	}
}

	