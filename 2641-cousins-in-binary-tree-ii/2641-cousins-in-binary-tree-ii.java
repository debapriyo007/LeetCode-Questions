/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        
        //bfs.
         Queue<TreeNode> q = new LinkedList<>();
         q.offer(root);
        
         ArrayList<Integer> list = new ArrayList<>();
        
         while(!q.isEmpty()){
          int levelSum = 0; //this sum is level of all sums.
          int size = q.size();
          for(int i = 0; i<size;i++){
              TreeNode currNode = q.poll();
              levelSum += currNode.val;
              
              if(currNode.left!= null) q.offer(currNode.left);
              if(currNode.right!= null) q.offer(currNode.right);
           }
           list.add(levelSum);
        }
        
        
         int index = 0;
         q.offer(root);
         root.val  = 0;
         while(!q.isEmpty()){
          int size = q.size();
          for(int i = 0; i<size;i++){
              TreeNode currNode = q.poll();
              int sum = 0; //sum of a particular node child.

              if(currNode.left!= null){
                  sum+= currNode.left.val;
              }
              if(currNode.right!= null){
                  sum+= currNode.right.val;
              }
              
              if(currNode.left!= null){
                  //replace the sum .
                  currNode.left.val = list.get(index+1) - sum;
                  q.offer(currNode.left);
              } 
              if(currNode.right!= null){
                    //replace the sum .
                  currNode.right.val = list.get(index+1) - sum;
                  q.offer(currNode.right);
              }
           }
          index++;
         
        }
        
         return root;
    }
}