class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        //first dir robot move.
        // N , E , S, W
        int[][]dir = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        
        int[]currPos = {0,0};
        //to store the obstacles creating map.
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[]obs : obstacles){
            if(!map.containsKey(obs[0])){
                map.put(obs[0], new HashSet<>());
            }
            map.get(obs[0]).add(obs[1]);
        }
        
        int currDir = 0;
        int ans = 0;
        for(int cmd : commands){
            if(cmd == -1){ // turn Right.
               currDir = (currDir+1)%4;
                continue;
            }
            if(cmd == -2){ // turn left.
                currDir = (currDir-1);
                if(currDir == -1){
                    currDir = 3;
                }
                 continue;
            }
            //move forward.
            int[]currDirection = dir[currDir];
            for(int i = 0;i<cmd;i++){
                int x_axis = currPos[0] + currDirection[0];
                int y_axis = currPos[1] + currDirection[1];
                if(map.containsKey(x_axis) && map.get(x_axis).contains(y_axis)){
                    break;
                }
                currPos[0] = x_axis;
                currPos[1] = y_axis;
            }
            ans = Math.max(ans,  currPos[0]* currPos[0] +  currPos[1]* currPos[1]);
        }
        return ans;
    }
}