class Pair{
    int fst; //this is the val
    int snd; //this is the min val
    
    Pair(int fst, int snd){
        this.fst = fst;
        this.snd = snd;
    }
}


class MinStack {
    Stack<Pair> stk;
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        int min = Integer.MAX_VALUE;
        if(stk.isEmpty()){
            stk.push(new Pair(val, val));
        }else{
            min = Math.min(val, stk.peek().snd);
            stk.push(new Pair(val, min));
        }
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek().fst;
    }
    
    public int getMin() {
        return stk.peek().snd;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */