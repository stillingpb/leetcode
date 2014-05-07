package round1;

import java.util.ArrayList;
import java.util.Collections;

public class Sort_List {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return val + "";
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
		int[] a1 = { 1, 4, 3, 5, 2 };
		Sort_List s = new Sort_List();
		ListNode head = s.creatLinkedList(a1);
		head = s.sortList(head);
		s.print(head);
	}

	public ListNode sortList(ListNode head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode dummy = head;
		while (dummy != null) {
			list.add(dummy.val);
			dummy = dummy.next;
		}
		Collections.sort(list);
		dummy = head;
		while (dummy != null) {
			dummy.val = list.remove(0);
			dummy = dummy.next;
		}
		return head;
	}
}
