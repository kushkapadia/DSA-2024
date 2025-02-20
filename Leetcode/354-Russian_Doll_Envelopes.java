class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Pair[] arr = new Pair[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            arr[i] = new Pair(envelopes[i][0], envelopes[i][1]);
        }
        Arrays.sort(arr);
        int[] dp = new int[envelopes.length];
        // apply LIS (longest increasing sub sequence on the 2nd value)
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            int low = 0;
            int high = ans;

            while (low < high) {
                int m = (low + high) / 2;

                if (dp[m] < arr[i].h) {
                    low = m + 1;
                } else {
                    high = m;
                }
            }

            dp[low] = arr[i].h;
            if (low == ans) {
                ans++;
            }
        }
        return ans;
    }
}

class Pair implements Comparable<Pair> {
    int w;
    int h;

    Pair(int w, int h) { // Constructor added
        this.w = w;
        this.h = h;
    }

    public int compareTo(Pair o) {

        if (this.w != o.w) {
            return this.w - o.w; // soprt asc on weights
        } else {
            return o.h - this.h;// sort desc on hieght
        }
    }
}

// steps:
/*
 * 1. sort asc on basis of any one value (hieght or width)
 * Note: If the values are same, then perfrom descending order sort on the 2nd
 * parameter
 * 2. on the second value perform longest increasing subsequence
 * 3. Calculate the length
 */