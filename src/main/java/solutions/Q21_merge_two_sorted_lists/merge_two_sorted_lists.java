// Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//  
// Example 1:
//
//
// Input: l1 = [1,2,4], l2 = [1,3,4]
// Output: [1,1,2,3,4,4]
//
//
// Example 2:
//
//
// Input: l1 = [], l2 = []
// Output: []
//
//
// Example 3:
//
//
// Input: l1 = [], l2 = [0]
// Output: [0]
//
//
//  
// Constraints:
//
//
// 	The number of nodes in both lists is in the range [0, 50].
// 	-100 <= Node.val <= 100
// 	Both l1 and l2 are sorted in non-decreasing order.
//
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //有序链表归并排
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);//虚拟头结点
        ListNode tail=dummy;
        while(l1!=null && l2!=null){
        	if(l1.val<=l2.val){
        		tail.next=l1;
        		tail=l1;
        		l1=l1.next;
        	}else{
        		tail.next=l2;
        		tail=l2;
        		l2=l2.next;
        	}
        }
        if(l1!=null){
        	tail.next=l1;
        }else{//l2==null || l2!=null
        	tail.next=l2;
        }
        return dummy.next;
    }
}
