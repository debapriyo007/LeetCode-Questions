class MyQueue {

    Stack<Integer> stk1, stk2;
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    
    public void push(int x) {
        
        //take out from stk1 and put into stk2.
        while(!stk1.isEmpty()){  
            stk2.push(stk1.pop());
        }
        stk1.push(x); // push the upcoming element.
        
        //put back into stk1 from stk2.
        while(!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }
    }
    
    public int pop() {
        if(stk1.isEmpty())return -1;
        return stk1.pop();
    }
    
    public int peek() {
        return stk1.peek();
    }
    
    public boolean empty() {
        return stk1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */