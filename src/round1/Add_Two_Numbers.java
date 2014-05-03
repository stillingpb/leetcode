package round1;

public class Add_Two_Numbers {
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
		int[] a1 = {9 };
		int[] a2 = { 9,9 };
		Add_Two_Numbers creator = new Add_Two_Numbers();
		ListNode head1 = creator.creatLinkedList(a1);
		ListNode head2 = creator.creatLinkedList(a2);
		ListNode head = creator.addTwoNumbers(head1, head2);
		creator.print(head);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int c = 0;
		ListNode newHead = l1;
		ListNode endl1 = null;
		while (l1 != null && l2 != null) {
			int temp = c + l1.val + l2.val;
			l1.val = temp % 10;
			c = temp / 10;
			if (l1.next == null)
				endl1 = l1;
			l1 = l1.next;
			l2 = l2.next;
		}
		if (endl1 != null) {
			endl1.next = l2;
			l1 = l2;
		}
		while (c != 0 && l1 != null) {
			int temp = l1.val + c;
			c = temp / 10;
			l1.val = temp % 10;
			if (l1.next == null)
				endl1 = l1;
			l1 = l1.next;
		}
		if (c != 0)
			endl1.next = new ListNode(c);
		return newHead;
	}
}
