
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stk.isEmpty() && k > 0 && stk.peek() > ch) { //if greater number in stk
                stk.pop();
                k--;
            }
            stk.push(ch);
        }
        //if there is any elements left..
        while (k > 0) {
            stk.pop();
            k--;
        }
        
        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }
        res.reverse();
        
        // Remove leading zeros
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        
        return res.toString().isEmpty() ? "0" : res.toString();
    }
}
