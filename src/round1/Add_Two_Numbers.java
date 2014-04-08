package round1;

import java.util.ArrayList;

public class Add_Two_Numbers {
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
		int[] a1 = { 3 };
		int[] a2 = {};
		Add_Two_Numbers creator = new Add_Two_Numbers();
		ListNode head1 = creator.creatLinkedList(a1);
		ListNode head2 = creator.creatLinkedList(a2);

		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(head1);
		lists.add(head2);

		ListNode h = creator.addTwoNumbers(head1, head2);
		while (h != null) {
			System.out.print(h.val + " ");
			h = h.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		ListNode head = new ListNode(0); // blank head
		ListNode cur = head;
		int c = 0;
		while (l1 != null && l2 != null) {
			int val = (l1.val + l2.val + c) % 10;
			c = (l1.val + l2.val + c) / 10;
			cur.next = new ListNode(val);
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int val = (l1.val + c) % 10;
			c = (l1.val + c) / 10;
			cur.next = new ListNode(val);
			cur = cur.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			int val = (l2.val + c) % 10;
			c = (l2.val + c) / 10;
			cur.next = new ListNode(val);
			cur = cur.next;
			l2 = l2.next;
		}
		if (c != 0)
			cur.next = new ListNode(c);
		return head.next;
	}
}
