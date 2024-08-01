class MyStack {
    Queue<Integer> q;
    public MyStack() {
         q = new LinkedList<>();  
    }
       
    
    public void push(int x) {
        int size = q.size();
        q.add(x);
        //here i the main case, where i add more than 1 ele it's break the stack rule.
        // so add take the prev add ele and put it befor curr add elem.
        for(int i = 0;i<size;i++){
            q.add(q.peek());
            q.remove();
        }
    
    }
    
    public int pop() {
       return q.remove();
       
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.size() == 0;
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