package round1;

import java.util.HashMap;

public class Copy_List_with_Random_Pointer {
	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	RandomListNode creatLinkedList(int[] a) {
		RandomListNode head = null;
		for (int i = a.length - 1; i >= 0; i--) {
			RandomListNode node = new RandomListNode(a[i]);
			node.next = head;
			head = node;
		}
		return head;
	}

	void print(RandomListNode node) {
		while (node != null) {
			System.out.print(node.label + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		Copy_List_with_Random_Pointer c = new Copy_List_with_Random_Pointer();
		RandomListNode head = c.creatLinkedList(a);
		head = c.copyRandomList(head);
		c.print(head);
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode node = head;
		while (node != null) {
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}
		RandomListNode copyHead = map.get(head);
		node = head;
		RandomListNode copy = copyHead;
		while (node != null) {
			copy.next = map.get(node.next);
			copy.random = map.get(node.random);
			node = node.next;
			copy = copy.next;
		}
		return copyHead;
	}
}
