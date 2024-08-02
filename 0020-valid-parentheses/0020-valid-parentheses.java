class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stk = new Stack<>();
        //fist i have to check for the "Opening "
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stk.push(ch);
            }else{
                if(stk.isEmpty())return false; //this is for only the opening or closeing brackets.
                if((stk.peek() == '(' && ch == ')') ||
                   (stk.peek() == '{' && ch == '}') ||
                   (stk.peek() == '[' && ch == ']')){
                    stk.pop();
                }else{
                    return false;
                }
            }
        }
        return (stk.isEmpty()) ? true: false;
    }
}