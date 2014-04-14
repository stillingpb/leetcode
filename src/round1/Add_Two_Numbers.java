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
		int[] a1 = { 2, 3 };
		int[] a2 = { 1, 2, 3 };
		Add_Two_Numbers creator = new Add_Two_Numbers();
		ListNode head1 = creator.creatLinkedList(a1);
		ListNode head2 = creator.creatLinkedList(a2);

		ListNode h = creator.addTwoNumbers(head1, head2);
		creator.print(h);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode newHead = new ListNode(0);
		ListNode newNode = newHead;
		while (l1 != null && l2 != null) {
			int cur = l1.val + l2.val + carry;
			newNode = newNode.next = new ListNode(cur % 10);
			carry = cur / 10;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int cur = l1.val + carry;
			newNode = newNode.next = new ListNode(cur % 10);
			carry = cur / 10;
			l1 = l1.next;
		}
		while (l2 != null) {
			int cur = l2.val + carry;
			newNode = newNode.next = new ListNode(cur % 10);
			carry = cur / 10;
			l2 = l2.next;
		}
		if (carry != 0)
			newNode.next = new ListNode(carry);
		return newHead.next;
	}
}
