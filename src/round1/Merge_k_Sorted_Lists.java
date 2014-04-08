package round1;

import java.util.ArrayList;

public class Merge_k_Sorted_Lists {

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

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4, 5 };
		int[] a2 = { 2, 3, 4, 4, 6 };
		int[] a3 = { 6, 7, 8, 9 };
		Merge_k_Sorted_Lists creator = new Merge_k_Sorted_Lists();
		ListNode head1 = creator.creatLinkedList(a1);
		ListNode head2 = creator.creatLinkedList(a2);
		ListNode head3 = creator.creatLinkedList(a3);

		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(head1);
		lists.add(head2);
		lists.add(head3);

		ListNode h = creator.mergeKLists(lists);
		while (h != null) {
			System.out.print(h.val + " ");
			h = h.next;
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		ListNode head = getMin(lists);
		ListNode cur = head;
		while (!lists.isEmpty()) {
			cur.next = getMin(lists);
			cur = cur.next;
		}
		return head;
	}

	private ListNode getMin(ArrayList<ListNode> lists) {
		int min = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) == null) {
				lists.remove(i);
				i--;
				continue;
			}
			if (lists.get(i).val < min) {
				min = lists.get(i).val;
				index = i;
			}
		}
		if (lists.size() == 0)
			return null;
		ListNode node = lists.get(index);
		lists.set(index, node.next);
		return node;
	}
}
