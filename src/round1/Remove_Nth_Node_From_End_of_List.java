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
			return "" + val;
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

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4, 5 };
		Remove_Nth_Node_From_End_of_List creator = new Remove_Nth_Node_From_End_of_List();
		ListNode head1 = creator.creatLinkedList(a1);

		head1 = creator.removeNthFromEnd(head1, 4);
		ListNode p = head1;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		while (n > 0) {
			fast = fast.next;
			n--;
		}
		if (fast == null)
			return head.next;
		fast = fast.next;
		ListNode slow = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}
}
