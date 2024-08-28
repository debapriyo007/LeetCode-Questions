class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String currString : details) {
            
            int x  = currString.charAt(11) - '0';
            int y  = currString.charAt(12) - '0';
            
            // String age = currString.substring(11, 13);
            // int newAge = Integer.parseInt(age);
            int newAge = 10*x + y;
            
            if (newAge > 60){cnt++;}
        }
        return cnt;
    }
}

