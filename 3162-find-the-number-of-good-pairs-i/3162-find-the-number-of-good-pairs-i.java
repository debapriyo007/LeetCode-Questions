//this is brute froce approach 
//Time Complexity 0(n^2)
// Space Complexity -> constant
class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        int n = nums1.length;
        int m = nums2.length;
        for(int i = 0;i<=n-1;i++){
            for(int j = 0;j<= m-1;j++){
                int div = nums2[j]*k;
                if(nums1[i] % div == 0){
                    count++;
                }
            }
        }
        
        return count;
    }
}