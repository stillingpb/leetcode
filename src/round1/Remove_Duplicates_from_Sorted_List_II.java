package round1;

public class Remove_Duplicates_from_Sorted_List_II {
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
		int[] a1 = { 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5 };
		Remove_Duplicates_from_Sorted_List_II r = new Remove_Duplicates_from_Sorted_List_II();
		ListNode head = r.creatLinkedList(a1);
		head = r.deleteDuplicates(head);
		r.print(head);
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode node = newHead;
		ListNode p2 = node.next;
		while (p2 != null) {
			boolean isSingle = true;
			int val = p2.val;
			while (p2.next != null && p2.next.val == val) {
				p2 = p2.next;
				isSingle = false;
			}
			if (isSingle)
				node = p2;
			else
				node.next = p2.next;
			p2 = p2.next;
		}
		return newHead.next;
	}
}
