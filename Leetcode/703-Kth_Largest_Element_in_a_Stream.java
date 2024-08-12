import java.util.*;

class KthLargest {
    int k;
    ArrayList arr = new ArrayList();

    public KthLargest(int k, int[] nums) {
        this.k = k;
   
        for (int i = 0; i < nums.length; i++) {
            this.arr.add(nums[i]);
        }

    }

    public int add(int val) {
       

        arr.add(val);
      Collections.sort(arr);

        return (int) arr.get(arr.size()-k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */