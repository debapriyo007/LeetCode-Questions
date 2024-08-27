class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        
        HashSet<String> set = new HashSet<>();
        for(String s : dictionary){
            set.add(s);
        }
     
        String[]wordsArr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String currWord : wordsArr){
            
            String replaceWord = currWord;
            for(int i = 0;i<currWord.length();i++){
                String prefix = currWord.substring(0, i+1);
                if(set.contains(prefix)){
                    replaceWord = prefix;
                    break;
                }
            }
            sb.append(replaceWord).append(" ");
        }
        return sb.toString().trim();
    }
}