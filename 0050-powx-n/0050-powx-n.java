class Solution {
    public double myPow(double x, int n) {
        
        double res = 1;
        long m = n; // coz of larger test cases.
        
        //handle the corner case here .. if n is (-)neg
        if(m<0) m = (-1)*m;
        while(m>0){
           if(m%2 == 0){
               // this the even(power) case -> 2^4 = (2^2)^2
               x = x*x;
               m = m/2; //then my power became half.
           }else{
               // odd case(power) 
               // 2^5 = 2 * 2^4
               res = x * res;
               m = m-1; //for the rest part.
           } 
        }
        return (n<0)? 1/res : res;
    }
}