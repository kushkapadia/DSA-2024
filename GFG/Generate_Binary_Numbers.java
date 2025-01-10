class solve {

    // Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int n) {
        // Your code here
        Queue<String> q = new LinkedList();
        ArrayList<String> al = new ArrayList();
        q.add("1");
        
        while(n != 0){
            String temp = q.remove();
            al.add(temp);
            q.add(temp + "0");
            q.add(temp + "1");
            n--;
        }
        return al;
        
    }
}
