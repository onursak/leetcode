/*

Time complexity: O(n) -> n is the max(lenght of l1, length of l2)
Space complexity: O(n) -> n is the max(lenght of l1, length of l2)

*/

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
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remainder = 0;
        ListNode result = null;
        ListNode resultPointer = result;
        while(l1 != null || l2 != null || remainder > 0){
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int actualSum = remainder + l1Val + l2Val;
            int reducedSum = actualSum % 10;
            remainder = actualSum >= 10 ? 1 : 0;
            if(resultPointer == null){
                result = new ListNode(reducedSum);
                resultPointer = result;
            }
            else{
                ListNode newNode = new ListNode(reducedSum);
                resultPointer.next = newNode;
                resultPointer = newNode;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return result;
    }
}
