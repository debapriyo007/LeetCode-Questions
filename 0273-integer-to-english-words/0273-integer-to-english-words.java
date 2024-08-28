class Solution {
    
    // ive to hard code the arrays.
    String[] bellowTen = {"", "One", "Two" , "Three", "Four" , "Five" , 
                          "Six" , "Seven" ,"Eight","Nine"};
    
     String[] bellowTwenty = {"Ten", "Eleven", "Twelve" , "Thirteen", "Fourteen" , "Fifteen" , 
                          "Sixteen" , "Seventeen", "Eighteen","Nineteen"};
    
     String[] bellowHurdred = {"", "Ten", "Twenty" , "Thirty", "Forty" , "Fifty" , 
                          "Sixty" , "Seventy", "Eighty","Ninety"};
    
    
    public String numberToWords(int num) {
        
        if(num == 0)return "Zero";
        //for the single digits.
        if(num <10)return bellowTen[num]; // 7 - > bellowTen[7]
        //if the number is double digits
        if(num < 20) return bellowTwenty[num-10]; // 17 -> bellowTwenty array (17-10) = 7 index get "Seventeen"
        // now check for bellow hundred.
        if(num<100){
            // 95 - > first get 9(Ninety) then concat with 5
            // there is another edge case if 90 -> dont consider the 0 
            return bellowHurdred[num/10] + (num%10!= 0 ? " " + bellowTen[num%10]:"");
        }
        
        //now check for three digits.
        if(num<1000){
            // go for -> 8 98 : 1st extract 9 then Recursion call for the rest 2 digits.
            return bellowTen[num/100] + " Hundred" + (num%100!= 0 ? " " + numberToWords(num%100):"");
        }
        if(num < 1000000){
            return numberToWords(num/1000) + " Thousand" +  (num%1000!= 0 ? " " + numberToWords(num%1000):""); 
        }
        
        if(num < 1000000000){
            return numberToWords(num/1000000) + " Million" +  (num%1000000!= 0 ? " " + numberToWords(num%1000000):""); 
        }
          
         return numberToWords(num/1000000000) + " Billion" +  (num%1000000000!= 0 ? " " + numberToWords(num%1000000000):""); 
          
    }
}