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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < lists.length; i++){
            while(lists[i]!=null){
                l.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        if(l.isEmpty()) return null;
        Collections.sort(l);
        ListNode head = new ListNode(l.get(0));
        ListNode cur = head;
        for(int i = 1; i < l.size(); i++){
            cur.next = new ListNode(l.get(i));
            cur = cur.next;
        }
        return head;
   }
}
