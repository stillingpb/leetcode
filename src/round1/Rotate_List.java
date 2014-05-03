package round1;

public class Rotate_List {
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
		Rotate_List r = new Rotate_List();
		ListNode head = r.creatLinkedList(a1);
		head = r.rotateRight(head, 7);
		r.print(head);
	}

	public ListNode rotateRight(ListNode head, int n) {
		int len = 0;
		ListNode node = head;
		for (; node != null; len++)
			node = node.next;
		ListNode fast = head;
		n = n % len;
		for (int i = 0; i < n && fast != null; i++)
			fast = fast.next;
		if (fast == null)
			return head;
		ListNode slow = head;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;
	}
}
