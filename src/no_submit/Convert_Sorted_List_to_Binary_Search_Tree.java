package no_submit;

import java.util.ArrayList;


public class Convert_Sorted_List_to_Binary_Search_Tree {
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

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public String toString() {
			return val + "";
		}
	}

	private void intraverse(TreeNode root) {
		if (root == null)
			return;
		intraverse(root.left);
		System.out.print(root.val + " ");
		intraverse(root.right);
	}

	private void pretraverse(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		pretraverse(root.left);
		pretraverse(root.right);
	}

	public static void main(String[] args) {
		Convert_Sorted_List_to_Binary_Search_Tree c = new Convert_Sorted_List_to_Binary_Search_Tree();
		ListNode head = c.creatLinkedList(new int[] {1 });
		TreeNode root = c.sortedListToBST(head);
		c.intraverse(root);
		System.out.println();
		c.pretraverse(root);
	}

	public TreeNode sortedListToBST(ListNode head) {
		ArrayList<Integer> vals = new ArrayList<Integer>();
		ListNode node = head;
		while (node != null) {
			vals.add(node.val);
			node = node.next;
		}
		return sortedListToBST(vals, 0, vals.size());
	}

	private TreeNode sortedListToBST(ArrayList<Integer> vals, int start, int len) {
		if (len == 0)
			return null;
		int mid = start + len / 2;
		TreeNode node = new TreeNode(vals.get(mid));
		node.left = sortedListToBST(vals, start, mid - start);
		node.right = sortedListToBST(vals, mid + 1, len + start - mid - 1);
		return node;
	}

}
