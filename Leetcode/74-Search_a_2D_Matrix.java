class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; //no.of rows
        int m = matrix[0].length; //no.of columns

        int low = 0;
        int high = m*n -1;

        while(low<=high){
            int mid = (low + high) / 2;
            int rowIndex = mid/m;
            int columnIndex = mid%m;

            if( matrix[rowIndex][columnIndex] == target ){
                return true;
            } else if(matrix[rowIndex][columnIndex] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return false;
    }
}


/*
Idea

Rule: To apply binary search on 2d array, treat the matrix as a 1d array.

*/