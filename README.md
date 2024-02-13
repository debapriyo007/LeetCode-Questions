# Advanced-DSA-STVR 🚀
Welcome to the Advanced Data Structure Concepts Repository! This repository is dedicated to providing a comprehensive collection of questions and concepts related to advanced data structures. Whether you're a student, educator, or professional seeking to deepen your understanding of data structures, this repository aims to be a valuable resource for you.



 ##  **Recursion 🙂**

| No   | Title                                    | Solution                                                      | Difficulty |
| --- | ---------------------------------------- | ------------------------------------------------------------- | ---------- |
| 1   | Combination Sum             | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0039-combination-sum/0039-combination-sum.java)          | Medium       |  
| 2   | Combination Sum - II            | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0040-combination-sum-ii/0040-combination-sum-ii.java)          | Medium       | 
| 3   | Palindrome Partitioning            | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0131-palindrome-partitioning/0131-palindrome-partitioning.java)   | Medium       | 
| 4   | Subset Sums | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/Medium/Subset%20Sums/subset-sums.java)                          | Medium       | 
| 5   | Subsets II | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0090-subsets-ii/0090-subsets-ii.java)                          | Medium       | 
| 6   | Kth Permutation Sequence  ❗️Doubt❗️ | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0060-permutation-sequence/0060-permutation-sequence.java)                          | Hard       | 
| 7   |  Permutations  | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0046-permutations/0046-permutations.java)                          |   Medium     | 
| 8   |  N-Queens  | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0051-n-queens/0051-n-queens.java)                          |   Hard     | 
| 9   |  Sudoku Solver  | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0037-sudoku-solver/0037-sudoku-solver.java)                          |   Hard     | 
| 10   |  Rat in a Maze Problem - I  | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/Medium/Rat%20in%20a%20Maze%20Problem%20-%20I/rat-in-a-maze-problem-i.java)      |   Medium     | 
| 11   |  Merge Sort | [Java](https://github.com/debapriyo007/Recursion-STVR/blob/main/0912-sort-an-array/0912-sort-an-array.java)      |   Medium     | 



##  **HashMap 🙂**

| No   | Title                                    | Solution                                                      | Difficulty |
| --- | ---------------------------------------- | ------------------------------------------------------------- | ---------- |
| 1   | Two Sum             | [Java](https://github.com/debapriyo007/Advanced-DSA-STVR/blob/main/0001-two-sum/0001-two-sum.java)          | Easy      |  
| 2   | Longest Consecutive Sequence | [Java](https://github.com/debapriyo007/Advanced-DSA-STVR/blob/main/0128-longest-consecutive-sequence/0128-longest-consecutive-sequence.java)          | Medium      | 
| 2   | Largest subarray with 0 sum | [Java](https://github.com/debapriyo007/Advanced-DSA-STVR/blob/main/Medium/Largest%20subarray%20with%200%20sum/largest-subarray-with-0-sum.java)    | Medium      | 







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
