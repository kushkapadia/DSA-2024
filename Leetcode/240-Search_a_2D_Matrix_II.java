class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length-1;

//place pointer on top right element
        int i = 0;
        int j = m;

        while( i < n && j>=0){ //rows are within limits and column count doesnt go below 0;

                if(matrix[i][j] ==  target){
                    return true;
                }
                else if(matrix[i][j] > target){
                    j--;
                } else{
                    i++;
                }
        }
        return false;
    }
}


/* Approach

Start from top right corner.
Observation 1 : All elements bigger than 15 are below.
Obs 2: All elements smaller than 15 are on the left.

if target = 5
then compare with 15,

if 5<15 go to left i.e j--;
if 5>15 go to below i.e i++;

In this way we reduce the search space.
Be careful to check bounding conditions.

*/