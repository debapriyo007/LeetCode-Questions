class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        List<String> list = new ArrayList<String>();
        HashSet<String> set = new HashSet<>();
        
        for(String ele:folder){
           set.add(ele);
        }
        
        for(String ele2: folder){
            list.add(ele2);
            for(int j=0;j<ele2.length();j++){
                if(ele2.charAt(j)=='/' && set.contains(ele2.substring(0,j))){
                    list.remove(list.size()-1);
                    break;
                }
            }
        }
        return list;
    }
}