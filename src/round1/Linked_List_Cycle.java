package round1;

import java.util.ArrayList;

public class Linked_List_Cycle {
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
		Linked_List_Cycle creator = new Linked_List_Cycle();
		ListNode head1 = creator.creatLinkedList(a1);
		
		System.out.println(creator.hasCycle(head1));
	}

	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast == null)
				return false;
			fast = fast.next;
			if(slow == fast)
				return true;
		}
		return false;
	}
}
