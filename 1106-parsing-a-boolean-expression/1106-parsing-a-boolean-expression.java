class Solution {
    public boolean parseBoolExpr(String expression) {
        
        Stack<Character> stk = new Stack<>();
        int n = expression.length();
        
        for(int i = 0;i<n;i++){
            char currCh = expression.charAt(i);
            if(currCh == ')'){
                ArrayList<Character> list = new ArrayList<>();
                while(stk.peek()!= '('){
                    list.add(stk.pop());
                }
                stk.pop(); //last '('
                char op = stk.pop();
                char ans = evulate(list, op);
                stk.push(ans);
            }else{
                if(currCh != ','){ //this the condition to skip the ','
                    //blind insetion.
                    stk.push(currCh);
                }
            }
        }
        return stk.peek() == 't' ? true : false;
    }
    
    char evulate(ArrayList<Character> list , char op){
        if(op == '&'){
            if(find(list, 'f')){
                return 'f';
            }else{
                return 't';
            }
        }
        if(op == '|'){
            if(find(list, 't')){
                return 't';
            }else{
                return 'f';
            }
        }
        
        return (list.get(0) == 't'?'f' :'t');
    }
    
    boolean find(ArrayList<Character> list, char val){
        for(char ch : list){
            if(ch == val){return true;}
        }
        return false;
    }
}