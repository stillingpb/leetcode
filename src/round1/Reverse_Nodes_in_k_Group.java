package round1;

public class Reverse_Nodes_in_k_Group {
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
		int[] a1 = { 1, 2, 3, 4, 5,6,7};
		Reverse_Nodes_in_k_Group r = new Reverse_Nodes_in_k_Group();
		ListNode head = r.creatLinkedList(a1);
		head = r.reverseKGroup(head, 8);
		r.print(head);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode start = newHead;
		while (start != null) {
			int i = 0;
			ListNode end = start.next;
			for (; i < k && end != null; i++)
				end = end.next;
			if (i < k)
				break;
			ListNode cur = start.next;
			ListNode subTail = cur;
			ListNode next = null;
			while (cur != end) {
				next = cur.next;
				cur.next = start.next;
				start.next = cur;
				cur = next;
			}
			subTail.next = end;
			start = subTail;
		}
		return newHead.next;
	}
}
