class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int diff=0;
        int arr[]=new int[2];
        for(int i=0;i<nums.length;i++){
        diff=target-nums[i];
         if(hm.containsKey(diff)){
             arr[0]=hm.get(diff);
             arr[1]=i;
         }  
            else{
                hm.put(nums[i],i);
            }
            
        }
        return arr;
    }
}