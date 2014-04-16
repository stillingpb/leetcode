package round1;

import java.util.ArrayList;

public class Swap_Nodes_in_Pairs {
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
		int[] a1 = { 1, 2, 3, 4, 5 };
		Swap_Nodes_in_Pairs creator = new Swap_Nodes_in_Pairs();
		ListNode head1 = creator.creatLinkedList(a1);
		head1 = creator.swapPairs(head1);
		creator.print(head1);
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode slow = newHead;
		ListNode fast = head.next;
		while (fast != null) {
			slow.next.next = fast.next;
			fast.next = slow.next;
			slow.next = fast;

			slow = fast.next;
			fast = slow.next;
			if (fast == null)
				break;
			fast = fast.next;
		}
		return newHead.next;
	}

}
