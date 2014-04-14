package round1;

public class Remove_Duplicates_from_Sorted_List {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
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
		int[] a1 = { 1, 1, 1, 2, 3, 3, 4 };
		int[] a2 = { 2, 3, 4, 4, 6 };
		Remove_Duplicates_from_Sorted_List creator = new Remove_Duplicates_from_Sorted_List();
		ListNode head1 = creator.creatLinkedList(a1);
		ListNode head2 = creator.creatLinkedList(a2);

		creator.removeDuplicate(head1);
		creator.print(head1);
	}

	public void removeDuplicate(ListNode head) {
		if (head == null)
			return;
		int curVal = head.val;
		ListNode node = head;
		while (node.next != null) {
			ListNode next = node.next;
			if (next.val == curVal) {
				node.next = next.next;
			} else {
				node = next;
				curVal = node.val;
			}
		}
	}
}
