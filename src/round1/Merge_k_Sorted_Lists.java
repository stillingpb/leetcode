package round1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists {
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
		int[] a1 = { 1 };
		int[] a2 = { 2, 6 };
		int[] a3 = { 6, 7 };
		Merge_k_Sorted_Lists creator = new Merge_k_Sorted_Lists();
		ListNode head1 = creator.creatLinkedList(a1);
		ListNode head2 = creator.creatLinkedList(a2);
		ListNode head3 = creator.creatLinkedList(a3);

		ArrayList<ListNode> lists = new ArrayList<ListNode>();
//		lists.add(head1);
//		lists.add(head2);
//		lists.add(head3);
		ListNode head = creator.mergeKLists(lists);
		creator.print(head);
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		PriorityQueue<ListNode> prioQueue = new PriorityQueue<ListNode>(
				10, new Comparator<ListNode>() {
					@Override
					public int compare(ListNode n1, ListNode n2) {
						return n1.val - n2.val;
					}
				});
		for (ListNode node : lists)
			if (node != null)
				prioQueue.offer(node);
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;
		while (!prioQueue.isEmpty()) {
			ListNode top = prioQueue.poll();
			cur.next = top;
			cur = top;
			if (top.next != null)
				prioQueue.offer(top.next);
		}
		return newHead.next;
	}
}
