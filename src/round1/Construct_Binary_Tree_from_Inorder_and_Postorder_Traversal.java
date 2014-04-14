package round1;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

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
		Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal c = new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		TreeNode root = c.buildTree(new int[] { 2, 4, 1, 5, 3 }, new int[] { 4,
				2, 5, 3, 1 });
		c.pretraverse(root);
		System.out.println();
		c.intraverse(root);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, postorder, 0, inorder.length);
	}

	private TreeNode buildTree(int[] inorder, int inStart, int[] postorder,
			int postStart, int len) {
		if (len == 0)
			return null;
		int val = postorder[postStart + len - 1];
		TreeNode node = new TreeNode(val);
		int i = inStart;
		for (; i < inStart + len; i++)
			if (inorder[i] == val)
				break;
		int leftLen = i - inStart;
		int rightLen = len - leftLen - 1;
		node.left = buildTree(inorder, inStart, postorder, postStart, leftLen);
		node.right = buildTree(inorder, i + 1, postorder, postStart + leftLen,
				rightLen);
		return node;
	}

}
