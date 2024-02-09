# Recursion-STVR 🚀
 **This Repository keep my Recursion Question and Concept here. 😅**

| No   | Title                                    | Solution                                                      | Difficulty |
| --- | ---------------------------------------- | ------------------------------------------------------------- | ---------- |
| 1   | Combination Sum             | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0039-combination-sum/0039-combination-sum.java)          | Medium       |  
| 2   | Combination Sum - II            | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0040-combination-sum-ii/0040-combination-sum-ii.java)          | Medium       | 
| 3   | Palindrome Partitioning            | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0131-palindrome-partitioning/0131-palindrome-partitioning.java)   | Medium       | 
| 4   | Subset Sums | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/Medium/Subset%20Sums/subset-sums.java)                          | Medium       | 
| 5   | Subsets II | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0090-subsets-ii/0090-subsets-ii.java)                          | Medium       | 
| 6   |  Permutation Sequence  ❗️Doubt❗️ | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0060-permutation-sequence/0060-permutation-sequence.java)                          | Hard       | 
| 7   |  Permutations  | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0046-permutations/0046-permutations.java)                          |   Medium     | 

Feel free to explore each solution for detailed explanations and implementations.

## Contributing 🧑🏽‍💻
#### Contributions are welcome! Feel free to open a pull request if you have a better solution or want to add solutions for new problems.








## Permutations(Approach - II) 🤓
- ### Approach : 
- `Take pointer on first element`
-  `Then Swap itself, Swap first element with the other left elements`
-  `Then Move Forward to the pointer for next element`
- ` And Recursively call, Till the Base case is not hit`
- `BASE CASE : My index reach the array length `

- ### Time Complexity : 0(n!) x n
  The n! is generating the parmutation and the 0(n) is for running the loop.
- ### Space Complexity : 0(n)

 ## Code 🧑‍💻
 
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Find(0, nums, ans);
        return ans;
        
    }
        public static void swap(int i, int j , int arr[]){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
    
    public static void Find(int index, int arr[],  List<List<Integer>> ans){
        //base case.
        if(index == arr.length){ //if my index size is reach length 
            //creating a new list ans add that list into my ans list.
           ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0;i<arr.length;i++){
                list.add(arr[i]);
            }
            ans.add(new ArrayList<>(list)); //here add in ans list.
            return;
        }
        
        for(int i = index;i<arr.length;i++){
            swap(i, index, arr); //swap loop varriable with curr position.
            Find(index+1, arr, ans); //call for next ele.
            swap(i, index, arr);
        }
    }
    
}

```
