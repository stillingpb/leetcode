package round1;

import round1.Remove_Nth_Node_From_End_of_List.ListNode;

public class Rotate_List {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return "" + val;
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
		int[] a1 = {1,2,3};
		Rotate_List creator = new Rotate_List();
		ListNode head1 = creator.creatLinkedList(a1);

		head1 = creator.rotateRight(head1, 5);
		ListNode p = head1;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
	}

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		int count = 0;
		while (p != null) {
			count++;
			p = p.next;
		}
		int site = count - n % count - 1;
		p = head;
		for (int i = 0; i < site; i++) {
			p = p.next;
		}
		ListNode mid = p;
		while (p.next != null)
			p = p.next;
		ListNode last = p;
		last.next = head;
		head = mid.next;
		mid.next = null;
		return head;
	}

}
