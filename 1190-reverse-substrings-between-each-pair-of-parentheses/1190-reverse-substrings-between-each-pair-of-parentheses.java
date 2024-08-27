class Solution {
    public String reverseParentheses(String s) {
        
        Stack<Character>stk = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == '('  || ch!= ')'){
                stk.push(ch);
            }else{
                ArrayList<Character> list = new ArrayList<>();
                while(!stk.isEmpty() && stk.peek() != '('){
                    list.add(stk.pop());
                }
                stk.pop(); // this backet is for to remove the last open parenthesis..
                //now again push all into stack.
                for(char listEle : list){
                    stk.push(listEle); 
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.insert(0, stk.pop());
        }
        return sb.toString();
    }
}