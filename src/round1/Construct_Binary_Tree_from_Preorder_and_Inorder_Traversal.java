package round1;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

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
		Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal c = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
		TreeNode root = c.buildTree(new int[] { 1, 2, 4, 3, 5 }, new int[] { 2,
				4, 1, 5, 3 });
		c.pretraverse(root);
		System.out.println();
		c.intraverse(root);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, inorder, 0, inorder.length);
	}

	private TreeNode buildTree(int[] preorder, int preStart, int[] inorder,
			int inStart, int len) {
		if (len == 0)
			return null;
		int val = preorder[preStart];
		TreeNode node = new TreeNode(val);
		int i = inStart;
		for (; i < inStart + len; i++)
			if (inorder[i] == val)
				break;
		int leftLen = i - inStart;
		int rightLen = len - leftLen - 1;
		node.left = buildTree(preorder, preStart + 1, inorder, inStart, leftLen);
		node.right = buildTree(preorder, preStart + leftLen + 1, inorder,
				inStart + leftLen + 1, rightLen);
		return node;
	}
}
