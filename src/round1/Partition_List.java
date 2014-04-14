package round1;


public class Partition_List {
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
		int[] a1 = {3,2,2,1,3,1 };
		Partition_List creator = new Partition_List();
		ListNode head1 = creator.creatLinkedList(a1);

		ListNode par = creator.partition(head1, 2);
		creator.print(par);
	}

	ListNode partition(ListNode head, int x) {
		ListNode lessHead = new ListNode(0);
		ListNode greatHead = new ListNode(0);

		ListNode lessNode = lessHead;
		ListNode greatNode = greatHead;

		ListNode node = head;
		while (node != null) {
			if (node.val < x) {
				lessNode.next = node;
				lessNode = node;
			} else {
				greatNode.next = node;
				greatNode = node;
			}
			node = node.next;
		}
		lessNode.next = greatHead.next;
		greatNode.next = null;
		return lessHead.next;
	}
}
