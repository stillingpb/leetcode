package round1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists2 {

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
		int[] a1 = { 1, 2, 2 };
		int[] a2 = { 1, 1, 2 };
		// int[] a3 = { 6, 7, 8, 9 };
		Merge_k_Sorted_Lists2 creator = new Merge_k_Sorted_Lists2();
		ListNode head1 = creator.creatLinkedList(a1);
		ListNode head2 = creator.creatLinkedList(a2);
		// ListNode head3 = creator.creatLinkedList(a3);

		ArrayList<ListNode> lists = new ArrayList<ListNode>();
//		lists.add(head1);
//		lists.add(head2);
		// lists.add(head3);

		ListNode h = creator.mergeKLists(lists);
		while (h != null) {
			System.out.print(h.val + " ");
			h = h.next;
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,
				new Comparator<ListNode>() {
					@Override
					public int compare(ListNode arg0, ListNode arg1) {
						return arg0.val - arg1.val;
					}
				});
		for (ListNode node : lists)
			if (node != null)
				heap.add(node);
		ListNode head = heap.poll();
		ListNode cur = head;
		if (cur != null && cur.next != null)
			heap.add(cur.next);
		while (!heap.isEmpty()) {
			cur.next = heap.poll();
			cur = cur.next;
			if (cur.next != null)
				heap.add(cur.next);
		}
		return head;
	}
}
