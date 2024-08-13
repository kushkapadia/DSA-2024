class MyStack {
Queue<Integer> que1;
Queue<Integer> que2;
    public MyStack() {
        this.que1 = new LinkedList();
        this.que2 = new LinkedList();
    }
    
    public void push(int x) {
        que1.add(x);
        //  System.out.println(que1);
    }
    
    public int pop() {
        int ans;
         System.out.println(que1);
        while(que1.size()>1){
            //    System.out.println(que1);

            que2.add(que1.poll());
              
        }
         System.out.println(que1);
         System.out.println(que2);
        ans = que1.poll();
        while(que2.size()>0){
            que1.add(que2.remove());
        }
        return ans;
    }
    
    public int top() {
           int ans;
        while(que1.size()>1){
            que2.add(que1.remove());
         
        }
        ans = que1.peek();
       
        que2.add( que1.poll());
        while(que2.size()>0){
            que1.add(que2.remove());
        }
        return ans;
    }
    
    public boolean empty() {
        if(que1.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */