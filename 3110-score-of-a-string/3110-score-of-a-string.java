class Solution {
    public int scoreOfString(String s) {
      
        ArrayList<Integer> list = new ArrayList<>();
        
        for(char ch : s.toCharArray()){
            list.add((int)ch);
        }
      
        int i = 0;
        int j = i+1;
        int sum = 0;
        while(i<list.size() && j < list.size()){
            int dif = Math.abs(list.get(i) - list.get(j));
            sum+= dif;
            i++;
            j++;
        }
        return sum;
    }
}