class Solution {
    public boolean checkIfExist(int[] arr) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int x : arr){
            if(set.contains(2*x) || (x%2 == 0 && set.contains(x/2))){
                return true;
            }
            set.add(x);
        }
        
        return false;
    }
}