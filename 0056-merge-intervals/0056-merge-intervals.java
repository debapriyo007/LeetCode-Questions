class Solution {
    public int[][] merge(int[][] intervals) {
        
        
        Arrays.sort(intervals, new Comparator<int[]>(){ // instated of this u use Lamda fun.
            @Override
            public int compare(int[]x,int[]y){
                return Integer.compare(x[0], y[0]);
            }
        });

        ArrayList<int[]>list = new ArrayList<>();
        int[]intvalArr = intervals[0];
        list.add(intvalArr);

        for(int[]currInterval : intervals){
            if(currInterval[0] <=  intvalArr[1]){
               intvalArr[1] = Math.max(currInterval[1],intvalArr[1]); 
            }else{
               intvalArr = currInterval;
               list.add(intvalArr);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}