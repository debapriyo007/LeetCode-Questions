/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head == null)return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        
        ListNode tem = head;
        while(tem!= null){
            pq.offer(tem);
            tem = tem.next;
        }
        
        head  = pq.poll(); //need sorted so make smallest as head node.
        tem = head; //for not loosing my head take pointer there.
        while(!pq.isEmpty()){
            tem.next = pq.poll();
            tem = tem.next;
        }
        tem.next = null;
        return head;
    }
}