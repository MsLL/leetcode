// Sort a linked list using insertion sort.
//
//
//
//
//
// A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
// With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
//  
//
//
//
//
// Algorithm of Insertion Sort:
//
//
// 	Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
// 	At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
// 	It repeats until no input elements remain.
//
//
//
// Example 1:
//
//
// Input: 4->2->1->3
// Output: 1->2->3->4
//
//
// Example 2:
//
//
// Input: -1->5->3->4->0
// Output: -1->0->3->4->5
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
    public ListNode insertionSortList(ListNode head) {
    	if(head==null || head.next==null){
    		return head;
    	}
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	ListNode tail=head;//已有序部分的尾,
        ListNode current=head.next;//当前待排序的结点,tail实际上就是current的前一个结点
        ListNode temp;
        while(current!=null){
        	temp=dummy;//找可插入位置的前一个结点∈[head,tail]
        	while(temp!=tail && temp.next.val<current.val){//若temp.next.val>=current.val,则可以插在temp的后面
        		temp=temp.next;
        	}
        	if(temp==tail){
        		tail=current;
        		current=current.next;
        	}else{
        		tail.next=current.next;
        		current.next=temp.next;
        		temp.next=current;
        		current=tail.next;//执向下一个带排序结点
        	}
        }
        return dummy.next;
    }
}
