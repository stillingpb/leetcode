package round1;

public class Merge_Two_Sorted_Lists {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4, 5 };
		int[] a2 = {};
		ListNode head1 = null;
		for (int i = a1.length - 1; i >= 0; i--) {
			ListNode node = new ListNode(a1[i]);
			node.next = head1;
			head1 = node;
		}
		ListNode head2 = null;
		for (int i = a2.length - 1; i >= 0; i--) {
			ListNode node = new ListNode(a2[i]);
			node.next = head2;
			head2 = node;
		}

		ListNode h = new Merge_Two_Sorted_Lists().mergeTwoLists(head1, head2);

		while (h != null) {
			System.out.print(h.val + " ");
			h = h.next;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		
		ListNode head;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		ListNode cur = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null)
			cur.next = l1;
		if (l2 != null)
			cur.next = l2;
		return head;
	}
}
