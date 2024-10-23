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
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<Long> list = new ArrayList<>();
        
        while(!q.isEmpty()){
            long sum = 0;
            int leveSize = q.size();
            
            for(int i = 0;i<leveSize;i++){
                TreeNode currNode = q.poll();
                sum+= currNode.val;
                
                if(currNode.left!= null)q.add(currNode.left);
                if(currNode.right!= null)q.add(currNode.right);
            }
            list.add(sum);
        }
        
        //Now K'th largest element concept.
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(long ele : list){
            pq.offer(ele);
        }
        int x = k-1;
        while(x>0){
            pq.poll();
            x--;
        }
        return (k > list.size()) ? -1 : pq.peek();
    }
}