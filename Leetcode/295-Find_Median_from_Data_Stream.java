class MedianFinder {

PriorityQueue<Integer> left; //max
PriorityQueue<Integer> right; //min
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size() == right.size()){
            right.add(num);
            left.add(right.remove());
        }else{
            left.add(num);
              right.add(left.remove());
        }
    }
    
    public double findMedian() {
        double median;
        if(left.size() == right.size()){
             median = ( right.peek() + left.peek())/2.0;
        } else{
             median = (int) left.peek() * 1.0;
        }
        return median;
    }
}





/**
 * 
 Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */