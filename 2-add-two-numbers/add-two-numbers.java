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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry=0;
        int sum=0;
        while(l1!=null && l2!=null){
            sum=l1.val+l2.val+carry;
                
                dummy.next=new ListNode((sum%10));
                carry=sum/10;
             
           

            
            dummy=dummy.next;
            l1=l1.next;
            l2=l2.next;
            
        }

        while(l1!=null){
            int sum1=l1.val+carry;
            dummy.next=new ListNode((sum1%10));
            dummy=dummy.next;
            carry=sum1/10;
            l1=l1.next;
             
        }

        while(l2!=null){
            int sum2=l2.val+carry;
            dummy.next=new ListNode((sum2%10));
            dummy=dummy.next;
            carry=sum2/10;
            l2=l2.next;
             
        }

        if (carry != 0) {
            dummy.next = new ListNode(carry);
        }

        return curr.next;

    }
}