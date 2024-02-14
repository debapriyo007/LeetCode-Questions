<h2><a href="https://leetcode.com/problems/permutations/">46. Permutations</a></h2><h3>Medium</h3><hr><div><p>Given an array <code>nums</code> of distinct integers, return <em>all the possible permutations</em>. You can return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [0,1]
<strong>Output:</strong> [[0,1],[1,0]]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> [[1]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 6</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li>All the integers of <code>nums</code> are <strong>unique</strong>.</li>
</ul>
</div>


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
