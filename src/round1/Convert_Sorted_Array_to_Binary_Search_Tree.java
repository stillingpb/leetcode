package round1;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
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
		Convert_Sorted_Array_to_Binary_Search_Tree c = new Convert_Sorted_Array_to_Binary_Search_Tree();
		TreeNode root = c.sortedArrayToBST(new int[]{1,2,3,4,5,6,7});
		c.pretraverse(root);
		System.out.println();
		c.intraverse(root);
	}

	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length);
	}

	private TreeNode sortedArrayToBST(int[] num, int start, int len) {
		if (len == 0)
			return null;
		int mid = start + len / 2;
		int val = num[mid];
		TreeNode node = new TreeNode(val);
		node.left = sortedArrayToBST(num, start, mid - start);
		node.right = sortedArrayToBST(num, mid + 1, len + start - mid - 1);
		return node;
	}

}
