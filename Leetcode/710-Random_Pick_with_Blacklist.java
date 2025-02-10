class Solution {

    int valid;
    HashMap<Integer, Integer> map;
    Random r;

    public Solution(int n, int[] blacklist) {
        valid = n - blacklist.length;
        map = new HashMap();
        r = new Random();

        for (int i = 0; i < blacklist.length; i++) {
            map.put(blacklist[i], -1);
        }

        for (int i = 0; i < blacklist.length; i++) {

            if (blacklist[i] < valid) {
                // n-1 because, it is 0 indexed
                while (map.containsKey(n - 1)) { /// if the number beyond thr valid line is blacklisted then move
                    n--;
                }
                map.put(blacklist[i], n - 1);
                n--;
            }
        }

    }

    public int pick() {
        int num = r.nextInt(0, valid);
        if(map.containsKey(num)){
            return map.get(num);
        } else{
            return num;
        }
    }
}

// example 1:
// we need to generate between 7-3 = 4
// Now map blacklisted with the correct number after the valid line
// 0
// 1
// 2 //bl --> mapped with 7
// 3 //bl -->6
// ----valid line
// 4
// 5 //blacklist
// 6

// O(m) //length of blacklist arrays
// Approach:
// There are in total N numbers, tha means valid numbers will be N - blacklist
// numbers.
// We will generate a random number between 0, N. But there are chances where
// the number gnerate is blacklisted, and we cannot return that. (this means,
// there only n-blacklist valid numbers) so we map the blacklist numbers to the
// other numbers that are not blacklisted
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */