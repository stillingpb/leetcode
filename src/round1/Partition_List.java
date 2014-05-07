package round1;

public class Partition_List {
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
		int[] a1 = { 5,4,3,2,1 };
		Partition_List p = new Partition_List();
		ListNode head = p.creatLinkedList(a1);
		head = p.partition(head, -1);
		p.print(head);
	}

	public ListNode partition(ListNode head, int x) {
		ListNode smallHead = new ListNode(0);
		ListNode bigHead = new ListNode(0);
		ListNode small = smallHead;
		ListNode big = bigHead;
		ListNode node = head;
		while (node != null) {
			if (node.val < x) {
				small.next = node;
				small = node;
			} else {
				big.next = node;
				big = node;
			}
			node = node.next;
		}
		big.next = null;
		small.next = bigHead.next;
		return smallHead.next;
	}
}
