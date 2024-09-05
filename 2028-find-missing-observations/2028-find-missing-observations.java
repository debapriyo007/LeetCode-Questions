class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        //cal the total sum.
        int m = rolls.length;
        int sum = (n + m) * mean;
        for(int num : rolls){
            sum-= num;
        }
        //edge case.
        if(sum < n || sum > n*6)return new int[]{};
        int avg = sum/n;
        int rem = sum%n;
        int[]ans = new int[n];
        for(int i = 0;i<n;i++){
            ans[i] = avg;
            //if any reminder is left
            if(rem>0){
                ans[i]++;
                rem--;
            }
        }
        return ans;
    }
}