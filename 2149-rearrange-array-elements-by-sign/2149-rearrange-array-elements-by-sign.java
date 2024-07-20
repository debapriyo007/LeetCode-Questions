class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        
        ArrayList<Integer> posList = new ArrayList<Integer>();
        ArrayList<Integer> negList = new ArrayList<Integer>();
        
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                 negList.add(nums[i]);
            }
            else {
                posList.add(nums[i]);
            }
        }
        
        int posIndex = 0;
        int negIndex = 0;
        int index = 0;
        while(posIndex < posList.size() && negIndex < negList.size()) {
            nums[index++] = posList.get(posIndex++);
            nums[index++] = negList.get(negIndex++);
        }
        
        while(posIndex < posList.size()) {
            nums[index++] = posList.get(posIndex++);
        }
        
        while(negIndex < negList.size()) {
            nums[index++] = negList.get(negIndex++);
        }
        return nums;
    }
}