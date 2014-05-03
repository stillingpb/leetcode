package round1;

import round2.Reverse_Nodes_in_k_Group.ListNode;

public class Reverse_Nodes_in_k_Group2 {
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
		int[] a1 = { 1, 2, 3, 4, 5, 6, 7 };
		Reverse_Nodes_in_k_Group2 r = new Reverse_Nodes_in_k_Group2();
		ListNode head = r.creatLinkedList(a1);
		head = r.reverseKGroup(head, 2);
		r.print(head);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;

		ListNode curHead = newHead;
		ListNode cur = newHead.next;
		while (cur != null) {
			int count = 0;
			for (; count < k && cur != null; count++)
				cur = cur.next;
			if (count < k)
				break;
			ListNode nextHead = cur;
			ListNode curTail = curHead.next;
			cur = curHead.next;
			while (cur != nextHead) {
				ListNode temp = cur.next;
				cur.next = curHead.next;
				curHead.next = cur;
				cur = temp;
			}
			curTail.next = nextHead;
			curHead = curTail;
		}
		return newHead.next;
	}
}
