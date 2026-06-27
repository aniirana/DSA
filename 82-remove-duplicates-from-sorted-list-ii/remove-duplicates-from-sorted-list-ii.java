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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;

        ListNode ans = new ListNode(0);
        ans.next = head;


        ListNode prev = ans;
        ListNode s=head;
        ListNode e=head;
        
        while(s != null){
            while(e != null && e.val==s.val){
                e=e.next;
            }
            if(s.next==e){
                prev=s;
            }
            else{
                prev.next=e;
            }
            s=e;
        }

        return ans.next;

    }
}