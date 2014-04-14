package round1;

public class Reverse_Linked_List_II {
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
		int[] a1 = { 1, 2, 3, 4 };

		Reverse_Linked_List_II creator = new Reverse_Linked_List_II();
		ListNode head1 = creator.creatLinkedList(a1);

		ListNode list = creator.reverseBetween1(head1, 2,2);
		creator.print(list);
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;

		if (m == 1) {
			// left right
			ListNode leftHead = head;
			ListNode leftTail = head;
			ListNode p = head.next; // point
			ListNode rightHead = null;
			int i = 1;
			while (i++ < n) {
				rightHead = p.next;
				p.next = leftHead;
				leftHead = p;
				p = rightHead;
			}
			leftTail.next = rightHead;
			return leftHead;
		}

		// left mid right
		ListNode p = head; // point
		int i = 1;
		while (i++ < m - 1)
			p = p.next;
		ListNode leftHead = p;
		p = p.next;
		ListNode midTail = p;
		ListNode midHead = p;
		p = p.next;
		ListNode rightHead = null;
		while (i++ < n) {
			rightHead = p.next;
			p.next = midHead;
			midHead = p;
			p = rightHead;
		}
		midTail.next = rightHead;
		leftHead.next = midHead;
		return head;
	}

	public ListNode reverseBetween1(ListNode head, int m, int n) {
		ListNode prefix = new ListNode(0); // dummy head
		prefix.next = head;

		int i = 1;
		while (i < m) {
			prefix = prefix.next;
			i++;
		}

		ListNode midTail = prefix.next;
		ListNode p = prefix.next;
		while (i <= n) {
			ListNode next = p.next;
			p.next = prefix.next;
			prefix.next = p;
			p = next;
			i++;
		}
		midTail.next = p;
		if (m == 1)
			return prefix.next;
		else
			return head;
	}
}
