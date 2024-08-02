class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        
        Stack <Integer> stk = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums2.length;
        for(int i = n-1;i>=0;i--){
            int ele = nums2[i];
            while(!stk.isEmpty() && stk.peek() <= ele){
                stk.pop();
            }
            if(stk.isEmpty()){
                map.put(ele, -1);
            }else{
                map.put(ele, stk.peek());
            }
            
            stk.push(ele);
        }
        
        int[]ans = new int[nums1.length];
        int index = 0;
        for(int ele :  nums1){
            if(map.containsKey(ele)){
                ans[index] = map.get(ele);
            }else{
                ans[index] = -1;
            }
            index++;
        }
        return ans;
    }
}