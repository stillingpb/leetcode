package round1;

public class Reorder_List {
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
		int[] a = {1,2,3,4,5,6,7};
		Reorder_List r = new Reorder_List();
		ListNode head = r.creatLinkedList(a);
		r.reorderList(head);
		r.print(head);
	}

	public void reorderList(ListNode head) {
		int len = calLen(head);
		ListNode firHead = new ListNode(0);
		firHead.next = head;
		ListNode secHead = cutList(head, (len + 1) / 2);
		reverseList(secHead);
		mergeList(firHead, secHead);
	}

	private void mergeList(ListNode firHead, ListNode secHead) {
		ListNode merNode = new ListNode(0);
		ListNode firNode = firHead.next;
		ListNode secNode = secHead.next;
		while (firNode != null) {
			merNode.next = firNode;
			merNode = firNode;
			firNode = firNode.next;
			merNode.next = secNode;
			if (secNode == null)
				return;
			merNode = secNode;
			secNode = secNode.next;
		}
	}

	private void reverseList(ListNode secHead) {
		ListNode node = secHead.next;
		ListNode tail = secHead.next;
		while (node != null) {
			ListNode next = node.next;
			node.next = secHead.next;
			secHead.next = node;
			node = next;
		}
		if (tail != null)
			tail.next = null;
	}

	private ListNode cutList(ListNode head, int len) {
		ListNode secHead = new ListNode(0);
		ListNode node = head;
		for (int i = 0; i < len; i++)
			node = node.next;
		secHead.next = node;
		return secHead;
	}

	private int calLen(ListNode head) {
		int len = 0;
		ListNode node = head;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}
}
