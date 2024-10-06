class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        
        //make sentence1 always smaller.
        if(sentence1.length() > sentence2.length()){
            return areSentencesSimilar(sentence2,sentence1);
        }
        String[]s1Arr = sentence1.split(" "); //smaller sentnce
        String[]s2Arr = sentence2.split(" ");  //larger sentence.
        
        int start = 0;
        int end1 = s1Arr.length-1;
        int end2 = s2Arr.length-1;
        
        //check for prefix word.
        while(start <= end1 && s1Arr[start].equals(s2Arr[start])){
            start++;
        }
        
        //check for suffix word.
         while(start <= end1 && s1Arr[end1].equals(s2Arr[end2])){
            end1--;
            end2--;
        }

        return (start > end1);
//         HashSet<String> set = new HashSet<>();  
//         for(String ele1 : s1Arr){
//             set.add(ele1);
//         }
        
//         int cnt = 0;
//         for(String s : s2Arr){
//             if(set.contains(s)){
//                 cnt++;
//             }
//         }
//         return (cnt >=2) ? true : false;
        
    }
}