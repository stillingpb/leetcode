package round1;

public class Remove_Nth_Node_From_End_of_List {
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
		Remove_Nth_Node_From_End_of_List r = new Remove_Nth_Node_From_End_of_List();
		int[] a1 = { 1, 2, 3, 4, 5 };
		ListNode head = r.creatLinkedList(a1);
		head = r.removeNthFromEnd(head, 1);
		r.print(head);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		int i = 0;
		while (i++ < n)
			fast = fast.next;
		ListNode newHead = new ListNode(0);
		ListNode slow = newHead;
		slow.next = head;
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return newHead.next;
	}
}
