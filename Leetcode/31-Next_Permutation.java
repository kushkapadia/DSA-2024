class Solution {
    public void nextPermutation(int[] arr) {
        int flag = 0;
        int ind = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
          
            if (arr[i + 1] > arr[i]) {

                ind = i;
         
                flag = 1;
                break;
            }
        }

        if (ind == -1) {
        
            int st = 0;
            int end = arr.length - 1;

            while (st < end) {
            int temp3 = arr[st];
            arr[st] = arr[end];
            arr[end] = temp3;

            end--;
            st++;
            }
            return;
        } else {

            int replaceIndex = ind + 1;
            int min = arr[ind + 1];
            for (int i = ind + 1; i < arr.length; i++) {
                if (min >= arr[i] && arr[ind] < arr[i]) {
                    replaceIndex = i;
                }
            }
        

            int temp = arr[ind];
            arr[ind] = arr[replaceIndex];
            arr[replaceIndex] = temp;

            

            int startP = ind + 1;
            int endP = arr.length - 1;
            while (startP < endP) {
                int temp2 = arr[startP];
                arr[startP] = arr[endP];
                arr[endP] = temp2;
                startP++;
                endP--;
            }
          
        }
    }
}