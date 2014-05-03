package round1;

public class Merge_Two_Sorted_Lists {
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
		int[] a1 = { 5 };
		int[] a2 = { 2, 3, 4, 4, 6 };
		Merge_Two_Sorted_Lists m = new Merge_Two_Sorted_Lists();
		ListNode head1 = m.creatLinkedList(a1);
		ListNode head2 = m.creatLinkedList(a2);
		ListNode head = m.mergeTwoLists(head1, head2);
		m.print(head);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				cur = l1;
				l1 = l1.next;
			}else{
				cur.next = l2;
				cur = l2;
				l2 = l2.next;
			}
		}
		if(l1 !=null)
			cur.next = l1;
		if(l2 != null)
			cur.next = l2;
		return newHead.next;
	}
}
