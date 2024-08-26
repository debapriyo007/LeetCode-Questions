class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize != 0)return false;
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        //put all the ele in treeMap.
        for(int ele : hand){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        
        while(map.size()>0){
            int currEle = map.entrySet().iterator().next().getKey();
            for(int i = 0;i<groupSize;i++){
                int nexConsEle = currEle + i;
                if(!map.containsKey(nexConsEle))return false;
                //if present.
                map.put(nexConsEle, map.get(nexConsEle)-1);
                
                //and if nexConsEle frq is 0 remove from map.
                if(map.get(nexConsEle) == 0){
                    map.remove(nexConsEle);
                }
            }
        }
        return true;
    }
}