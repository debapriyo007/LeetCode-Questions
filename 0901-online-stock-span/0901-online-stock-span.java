class StockSpanner {

    Stack<Integer> stk;
    ArrayList<Integer> list;
    public StockSpanner() {
        stk = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        
        while(!stk.isEmpty() && list.get(stk.peek()) <= price){
            stk.pop();
        }
        
        int prevIndex = (stk.isEmpty()) ? -1 : stk.peek();
        int currIndex = list.size()-1;
        int ans = currIndex - prevIndex;
        stk.push(currIndex); 
        return ans;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */