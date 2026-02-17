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
    public ListNode removeZeroSumSublists(ListNode head){
        ListNode p = new ListNode(0);
        p.next = head;
        
        HashMap<Integer,ListNode> map=new HashMap<>();
        int prefix = 0;
        for(ListNode curr=p;curr!=null;curr=curr.next){
            prefix += curr.val;
            map.put(prefix,curr);
        }        
        prefix = 0;
        for(ListNode curr=p;curr!=null;curr=curr.next){
            prefix+=curr.val;
            curr.next=map.get(prefix).next;
        }
        
        return p.next;
    }
}
