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
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        //add all ele in set.
        HashSet<Integer> set = new HashSet<>();
        for (int ele : nums) {
            set.add(ele);
        }
        
        //now iterae through the list if the node is present in the set remove that node.
        ListNode dummy = new ListNode(0);
        dummy.next = head;  //ex2 : dummy -> 1 -> 2 -> 1 -> 2 -> 1 -> 2 ->null
        ListNode prev = dummy; 
        ListNode curr = head;

        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}



class FistTrial {
// public ListNode modifiedList(int[] nums, ListNode head) {
        
//         for(int ele: nums){ // Pass Only 18 TestCase..
//             if(head.val == ele){
//                 head = head.next;
//             }
//             ListNode tem = head;
//             ListNode prev = head;
            
//             while(tem!= null){
//                 if(tem.val!= ele){
//                     tem = tem.next;
//                 }else{
//                     prev.next = tem.next;
//                     tem = tem.next;
//                     prev = prev.next;
//                 }
//             }
//         }
//         return head;
        
    
//         HashMap<Integer, Integer> map = new HashMap<>();  //pass 301 TestCase
//         ListNode tem = head;
//         while(tem!= null){
//             map.put(tem.val, map.getOrDefault(tem.val, 0)+1);
//             tem = tem.next;
//         }
       
//         for(int ele:nums){
//             if(map.containsKey(ele)){
//                 //remove from map utill freq is zero.
//                 map.put(ele, map.get(ele)-1);
//                 //if my ele frq is totally 0 remove.
//                 if(map.get(ele) == 0){
//                     map.remove(ele);
//                 }
//             }
//         }
        
//         //nOW Redbuild the list.
//         ListNode dummy = new ListNode(0);
//         ListNode curr = dummy;
        
//         tem = head;
//         while(tem!= null){
//             if(map.containsKey(tem.val) && map.get(tem.val) > 0){
//                 //take out that val and using that create new node.
//                 curr.next = new ListNode(tem.val);
//                 curr = curr.next;
//                 //decrease the frq from map.
//                 map.put(tem.val, map.get(tem.val)-1);
//             }
//             tem = tem.next;
//         }
//         return dummy.next;
//}
}