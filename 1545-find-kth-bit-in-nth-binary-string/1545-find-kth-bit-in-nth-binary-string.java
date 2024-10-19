class Solution {
    public char findKthBit(int n, int k) {
        
        String ans = helper(n);
        return ans.charAt(k-1);
        
    }
    
     String reverse(String str){
	    StringBuilder sb = new StringBuilder(str);
	    sb.reverse();
	    return sb.toString();
	}
	
	 String replace0_1(String str){
	    StringBuilder sb = new StringBuilder();
	    for(char ch : str.toCharArray()){
	        sb.append((ch == '0' ? '1' : '0'));
	    }
	   return sb.toString();
	}
		
	 String helper(int n){
	    if(n == 1){
	        return "0";
	    }
	    return helper(n-1) + "1" + reverse(replace0_1(helper(n-1)));
	}
}