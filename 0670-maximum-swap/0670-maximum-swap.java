class Solution {
    public int maximumSwap(int num) {
    
        char[] numArr = String.valueOf(num).toCharArray();
        int n = numArr.length;
        char maxEle = numArr[n-1];
        int maxIndex = n-1;
        
        int swapIndex1 = -1;
        int swapIndex2 = -1;
        
        for(int i = n-2 ;i>= 0 ;i--){
            if(numArr[i] > maxEle){
                maxEle = numArr[i];
                maxIndex = i;
            }else if(numArr[i] < maxEle){
                swapIndex1 = i;
                swapIndex2 = maxIndex;
            }
        }
        
        //perfrom swaping.
        if(swapIndex1!= -1){
            char tem = numArr[swapIndex1];
            numArr[swapIndex1] = numArr[swapIndex2];
            numArr[swapIndex2] = tem;
        }
        return Integer.parseInt(new String(numArr));
    }
}
