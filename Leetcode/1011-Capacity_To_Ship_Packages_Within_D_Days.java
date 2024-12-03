class Solution {

    public int calculate(int[] weights, int m) {
        int days = 1;
        int sum = 0;
        for (int w : weights) {
            if (sum + w > m) {
                days++;
                sum = 0;
            }

            sum = sum + w;
        }
        return days;
    }

    public int maxArr(int[] weights) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < weights.length; i++) {
            if (max < weights[i]) {
                max = weights[i];
            }

        }
        return max;
    }

    public int sumArr(int[] weights) {
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {

            sum = sum + weights[i];

        }
        return sum;
    }

    public int shipWithinDays(int[] weights, int days) {
        int ans = 0;
        int low = maxArr(weights);// max of the weights;
        int high = sumArr(weights);// sum of the array;
        System.out.println("LOW " + low);
        System.out.println("High " + high);

       
        while (low <= high) {
             int m = low + (high - low) / 2;
            int requiredDays = calculate(weights, m);

            if (requiredDays <= days) {
                ans = m;
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return ans;
    }
}

// 4 5 6 7 8 9 10

// ans = 6
// required = 7
// allopwed = 3