//Note: Minimum number of bricks crossed = maximum number of empty spaces

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        // this problem can be solved using prefix sum and hashmap
        // the prefix sum of each sublist tell us where the brick end(break)
        // eg: row 1: 1 2 2 1
        // therefore, theres a break on 1, 3,5,6 (6 will be ignored as it is end)

        HashMap<Integer, Integer> map = new HashMap();
        int ans = 0; //empty spaces
        for (List<Integer> subList : wall) {

            int len = 0;
            for (int i = 0; i < subList.size() - 1; i++) {
                len = len + subList.get(i);
                map.put(len, map.getOrDefault(len, 0) + 1);
                ans = Math.max(ans, map.get(len));
            }
        }
        return wall.size() - ans; //wall.size (6 layers (vertical)) - maximum number of empty spaces = bricks crossed

        // [[], [], []]
    }
}