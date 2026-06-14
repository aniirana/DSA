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
        ListNode other = null;
        ListNode temp = head;

        while (temp != null) {
            other = new ListNode(temp.val, other);
            temp = temp.next;
        }

        int max=0;
        temp=head;
        while(temp!=null){
            int sum=temp.val+other.val;
            max=Math.max(max,sum);
            temp=temp.next;
            other=other.next;
        }
        return max;


    }
}