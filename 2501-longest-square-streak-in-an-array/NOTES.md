class Solution {
public int longestSquareStreak(int[] nums) {
HashSet<Long> set = new HashSet<>();
for (int x : nums) {
set.add((long)x);
}
// ArrayList<Integer> list = new ArrayList<>();
int maxCnt = -1;
for(int x : nums){
int cnt = 1;
long currEle = x;
while(set.contains((int)(currEle*currEle))){
currEle = currEle*currEle;
cnt++;
}
maxCnt = Math.max(maxCnt, cnt);
}
return (maxCnt < 2) ? -1 : maxCnt;
}
}