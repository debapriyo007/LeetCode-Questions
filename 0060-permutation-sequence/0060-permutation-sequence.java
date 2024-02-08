class Solution {
    public String getPermutation(int n, int k) {
        
        int fac = 1;
        List<Integer> list = new ArrayList<>();
        
        //here we compute (n-1) factorial.
        // if n = 4 the first block of size is 6 that's nothing but (n-1) factorial.
        for(int i = 1;i<n;i++){
            fac = fac*i; //this will calc the factorial.
            list.add(i); //this loop add [1, 2,3]
        }
        list.add(n); //this is add only "4" in the list if n = 4
        //so the list become [1, 2, 3, 4]
        
        String ans = ""; //my return type is String 
        //k = k-1 coz in our logic we are considering 0th base indexing..
        k = k-1;
        // if they want 17 th parmutation we will find for 16th parmutation.
        
        while(true){   // Infinite time run whenever list is't empty.
            ans = ans + list.get(k/fac);
            //remove last insert index element.
            list.remove(k/fac);
            if(list.size() == 0)break;
            
            k = k%fac; //we want next value of K
            fac = fac/list.size(); // my block size is first 6 then it's become 2 
            //means it's reduce 6/3!(here 3 is noting but the size of list.)
        }
        return ans; //return ans
    }
}