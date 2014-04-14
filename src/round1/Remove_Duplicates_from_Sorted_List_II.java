package round1;

import java.util.ArrayList;

public class Remove_Duplicates_from_Sorted_List_II {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	ListNode creatLinkedList(int[] a) {
		ListNode head = null;
		for (int i = a.length - 1; i >= 0; i--) {
			ListNode node = new ListNode(a[i]);
			node.next = head;
			head = node;
		}
		return head;
	}

	void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 2, 3, 4, 4, 5, 5 };
		Remove_Duplicates_from_Sorted_List_II creator = new Remove_Duplicates_from_Sorted_List_II();
		ListNode head1 = creator.creatLinkedList(a1);

		ListNode head = creator.deleteDuplicates(head1);
		creator.print(head);
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode newEnd = newHead;

		boolean isSingle = true;
		ListNode single = head;
		int curVal = head.val;
		ListNode node = head.next;

		while (node != null) {
			if (curVal == node.val) {
				isSingle = false;
			} else {
				if (isSingle) {
					newEnd.next = single;
					newEnd = single;
				}
				curVal = node.val;
				isSingle = true;
				single = node;
			}
			node = node.next;
		}
		if (isSingle) {
			newEnd.next = single;
		} else
			newEnd.next = null;
		return newHead.next;
	}

}
