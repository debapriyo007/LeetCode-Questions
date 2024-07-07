class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
        
        int x = numBottles;
        while(numBottles>= numExchange){
            x += numBottles/numExchange; // get full water bottles
            numBottles = numBottles/numExchange + (numBottles%numExchange); //new bottles are formed
        }
        return x;
    }
}