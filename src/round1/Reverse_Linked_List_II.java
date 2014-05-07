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
		int[] a1 = { 1, 2, 3, 4, 5 };
		Reverse_Linked_List_II r = new Reverse_Linked_List_II();
		ListNode head = r.creatLinkedList(a1);
		head = r.reverseBetween(head, 3, 3);
		r.print(head);
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode tail1 = newHead;
		for (int i = 1; i < m; i++)
			tail1 = tail1.next;
		ListNode tail2 = tail1.next;
		ListNode node = tail1.next;
		for (int i = m; i <= n; i++) {
			ListNode next = node.next;
			node.next = tail1.next;
			tail1.next = node;
			node = next;
		}
		tail2.next = node;
		return newHead.next;
	}
}
