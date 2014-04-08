package util;

import java.util.ArrayList;

public class LinkedListCreator {
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

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4, 5 };
		int[] a2 = { 2, 3, 4, 4, 6 };
		int[] a3 = {6,7,8,9};
		LinkedListCreator creator = new LinkedListCreator();
		ListNode head1 = creator.creatLinkedList(a1);
		ListNode head2 = creator.creatLinkedList(a2);
		ListNode head3 = creator.creatLinkedList(a3);

		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(head1);
		lists.add(head2);
		lists.add(head3);
	}
}
