class Solution {
    public int findCenter(int[][] edges) {
        
        int[] pair1 = edges[0]; // v1, v2
        int[] pair2 = edges[1]; // v1, v3 || v2, v3
        
        if(pair1[0] == pair2[0] || pair1[0] == pair2[1]){
            return pair1[0];
        }
        return pair1[1];
        
        
        /* 
            int totalEdges = edges.length;
            HashMap<Integer, Integer> freqMap = new HashMap<>();

            for(int edge[] : edges){
                int v1 = edge[0];
                int v2 = edge[1];

                freqMap.put(v1, freqMap.getOrDefault(v1, 0)+1);
                freqMap.put(v2, freqMap.getOrDefault(v2, 0)+1);

                if(totalEdges == freqMap.get(v1)){
                    return v1;
                }
                 if(totalEdges == freqMap.get(v2)){
                    return v2;
                }
            }
            return -1;

        */
    }
}