class Solution {
    public int compareVersion(String version1, String version2) {
        
//         String version11 = version1.replace("." , "");
//         String version22 = version2.replace("." , "");
        
        
//         int v1 = Integer.parseInt(version11);
//         int v2 = Integer.parseInt(version22);
        
//         if(v1>v2){
//             return 1;
//         }else if(v2>v1){
//             return -1;
//         }else{
//             return 0;
//         }
        
        
        String[]v1 = version1.split("\\.");
        String[]v2 = version2.split("\\.");
        
        for(int i = 0;i<Math.max(v1.length, v2.length);i++){
            int n1 = (i>= v1.length) ? 0 : Integer.parseInt(v1[i]);
            int n2 = (i>= v2.length) ? 0 : Integer.parseInt(v2[i]);
             if(n1>n2)return 1;
             if(n1<n2)return -1;
        }
        return 0;  
    }
}