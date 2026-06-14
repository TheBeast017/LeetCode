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
    public int pairSum(ListNode head) {
        List<Integer> l = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            l.add(p.val);
            p = p.next;
        }
        int i = 0, j = l.size()-1;
        int mval = 0;
        while (i < j) {
            mval = Math.max(mval, l.get(i++) + l.get(j--));
        }
        return mval;
    }
}