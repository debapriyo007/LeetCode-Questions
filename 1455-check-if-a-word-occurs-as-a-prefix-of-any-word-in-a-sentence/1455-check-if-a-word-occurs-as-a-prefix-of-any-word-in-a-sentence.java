class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        
        //split base of space.
        String[]senAr = sentence.split(" ");
        // System.out.println("Split array is : " + Arrays.toString(senAr));
        
        for(int i = 0;i<senAr.length;i++){
            String currString = senAr[i];
            // System.out.println("Curr STRING : " + currString);
            if(currString.startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }
}