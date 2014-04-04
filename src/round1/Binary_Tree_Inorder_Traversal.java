package round1;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {

	public static void main(String[] args) {
		Binary_Tree_Inorder_Traversal m = new Binary_Tree_Inorder_Traversal();
		TreeNode root = m.createTree();
		List<Integer> list = m.inorderTraversal(root);
		for (int i : list)
			System.out.print(i + "\t");
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode createTree() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left = t2;
		t1.right = t3;
		t2.right = t4;
		t3.left = t5;
		return t1;
	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			while (node != null) {
				s.push(node);
				node = node.left;
			}
			if (!s.isEmpty()) {
				node = s.pop();
				list.add(node.val);
				s.push(node.right);
			}
		}
		
		// TreeNode p = root;
		// if (p == null)
		// return list;
		// stack.push(p);
		// while (!stack.isEmpty()) {
		// p = stack.pop();
		// while (p != null) {
		// stack.push(p);
		// p = p.left;
		// }
		// p = stack.pop();
		// list.add(p.val);
		// // System.out.println(p.val);
		// while (!stack.isEmpty() && p.right == null) {
		// p = stack.pop();
		// list.add(p.val);
		// // System.out.println(p.val);
		// }
		// if (p.right != null)
		// stack.push(p.right);
		// }
		return list;
	}
}
