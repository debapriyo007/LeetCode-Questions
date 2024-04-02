class Solution {
    public int reverse(int x) {
        long rev = 0;
        while(x!=0){
            int lastDigt = x%10;
            rev = (rev*10)+lastDigt;
            //check here for the test case condition.
            if(rev>Integer.MAX_VALUE || rev<Integer.MIN_VALUE)return 0;
            x = x/10;
        }
        return (int)rev;
    }
}