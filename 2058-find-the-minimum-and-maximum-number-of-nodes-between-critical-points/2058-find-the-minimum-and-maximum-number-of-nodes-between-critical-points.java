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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // if size is less than or equal to 2
        if(head == null || head.next == null || head.next.next == null){
            return new int[]{-1, -1};
        }
        // find out the critial points.
        List<Integer> list = new ArrayList<>();
        ListNode tem = head.next;
        ListNode prev = head;
        int count = 1;
        while(tem.next != null){
            count++;
            if((tem.val > prev.val && tem.val > tem.next.val) 
               ||(tem.val < prev.val && tem.val < tem.next.val)){
 
                list.add(count);
                
            }
            tem = tem.next;
            prev = prev.next;
        }
        //if one criticial point exist then return [-1,-1]
        if(list.size()<2) return new int[]{-1, -1};

        //maximum alway be dif between last and fst node.
        int fstNode = list.get(0);
        int lastNode = list.get(list.size()-1);
        
        int maxDis = lastNode-fstNode;;
        
        //now find the minimum..
        int minDis = Integer.MAX_VALUE;
        for(int i = 0 ; i <list.size()-1;i++){
            minDis = Math.min(minDis,list.get(i+1)-list.get(i));
        }

        
        return  new int[]{minDis, maxDis}; //ans
    }
}