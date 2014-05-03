package round1;

import java.util.ArrayList;

public class Insertion_Sort_List {
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
		int[] a1 = { 2, 3, 1, 5, 4 };
		Insertion_Sort_List creator = new Insertion_Sort_List();
		ListNode head1 = creator.creatLinkedList(a1);
		head1 = creator.insertionSortList(head1);
		creator.print(head1);
	}

	public ListNode insertionSortList(ListNode head) {
		if(head==null)
			return head;
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		ListNode node = head;
		while (node != null) {
			list.add(node);
			node = node.next;
		}
		for (int i = 1, len = list.size(); i < len; i++) {
			ListNode nodei = list.get(i);
			int j = i - 1;
			for (; j >= 0; j--) {
				ListNode nodej = list.get(j);
				if (nodei.val > nodej.val)
					break;
				list.set(j + 1, nodej);
			}
			list.set(j + 1, nodei);
		}
		for (int i = 1, len = list.size(); i < len; i++) {
			list.get(i - 1).next = list.get(i);
		}
		list.get(list.size() - 1).next = null;
		return list.get(0);
	}
}
