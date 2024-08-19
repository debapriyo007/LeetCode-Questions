class Solution {
    public String sortSentence(String s) {
        
        HashMap<Integer, String> map = new HashMap<>();
        
        for(String word : s.split(" ")){
            
            // find the last index.
            int lastIndex = word.length() - 1;
            int index = word.charAt(lastIndex) - '0';
            
            String accWord = word.substring(0, lastIndex);
            map.put(index,accWord);
        }
        
        //take a ds and iterate through map and put it into ds.
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer,String> ele :  map.entrySet()){
            sb.append(ele.getValue());
            sb.append(" ");
        }
        return sb.toString().trim(); // trim is use for remove the last space
    }
}