// Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
//
//
//
// The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
//
//
// Example:
//
// Given matrix = [
//   [3, 0, 1, 4, 2],
//   [5, 6, 3, 2, 1],
//   [1, 2, 0, 1, 5],
//   [4, 1, 0, 1, 7],
//   [1, 0, 3, 0, 5]
// ]
//
// sumRegion(2, 1, 4, 3) -> 8
// sumRegion(1, 1, 2, 2) -> 11
// sumRegion(1, 2, 2, 4) -> 12
//
//
//
// Note:
//
// You may assume that the matrix does not change.
// There are many calls to sumRegion function.
// You may assume that row1 ≤ row2 and col1 ≤ col2.
//
//


    public class NumMatrix {
    	private int[][] area;//用dp[i][j]代表矩形(0,0,i,j)的面积
        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                     return;
            }
        	area=new int[matrix.length][matrix[0].length];
        	area[0][0]=matrix[0][0];
        	//初始化第一行
        	for(int j=1;j<matrix[0].length;j++){
        		area[0][j]=matrix[0][j]+area[0][j-1];
        	}
        	//初始化第一列
        	for(int i=1;i<matrix.length;i++){
        		area[i][0]=matrix[i][0]+area[i-1][0];
        	}
        	for(int i=1;i<matrix.length;i++){//逐行填
        		for(int j=1;j<matrix[0].length;j++){
        			area[i][j]=area[i][j-1]+area[i-1][j]-area[i-1][j-1]+matrix[i][j];
        		}
        	}
        }
        public int sumRegion(int row1, int col1, int row2, int col2) {
        	if(col1-1>=0 && row1-1>=0){//可以分为3块。等价于col1>=1 && row1>=1
        		return area[row2][col2]-area[row2][col1-1]-area[row1-1][col2]+area[row1-1][col1-1];
        	}else{
        		if(col1==0 && row1==0){
        			return area[row2][col2];
        		}else if(col1==0){
        			return area[row2][col2]-area[row1-1][col2];
        		}else{//row1==0
        			return area[row2][col2]-area[row2][col1-1];
        		}
        	}
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
