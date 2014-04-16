package round1;

import java.util.HashSet;

public class Linked_List_Cycle_II {
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
		Linked_List_Cycle_II l = new Linked_List_Cycle_II();
		ListNode head = l.creatLinkedList(new int[] { 1, 2, 3, 4 });
//		ListNode node = head.next.next;
//		node.next.next = node;
		System.out.println(l.detectCycle(head));
	}

	public ListNode detectCycle(ListNode head) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		ListNode node = head;
		while (node != null) {
			if (set.contains(node))
				return node;
			set.add(node);
			node = node.next;
		}
		return null;
	}
}
