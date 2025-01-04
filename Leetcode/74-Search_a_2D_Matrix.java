class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; //no.of rows
        int m = matrix[0].length; //no.of columns

        int low = 0; 
        int high = m*n -1; //high == last index of matrix

        while(low<=high){
            int mid = (low + high) / 2;
            int rowIndex = mid/m; //to convert 1d array index into 2d array row index;
            int columnIndex = mid%m; //to convert 1d array index into 2d array column index;

            if( matrix[rowIndex][columnIndex] == target ){
                return true; //if mid elemnt is target then return true;
            } else if(matrix[rowIndex][columnIndex] < target){
                low = mid + 1; //if m,id element is less then target, then search to the right.
            } else{
                high = mid - 1; //else search to the left.
            }
        }
        return false;
    }
}


/*
Idea

Rule: To apply binary search on 2d array, treat the matrix as a 1d array.

*/
