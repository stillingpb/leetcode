package round1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Populating_Next_Right_Pointers_in_Each_Node_II {
	static class TreeLinkNode {
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;

		TreeLinkNode(int x) {
			val = x;
		}

		public String toString() {
			return val + "";
		}
	}

	public TreeLinkNode createTree() {
		String treeStr = "1,2,3,4,5,6,7";
		// String treeStr = "3,1,5,0,2,4,6,#,#,#,3";
		String[] nstr = treeStr.split(",");
		List<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();
		nodes.add(new TreeLinkNode(Integer.parseInt(nstr[0])));
		for (int i = 1, count = 0; i < nstr.length; i++, count++) {
			if ("#".equals(nstr[i]))
				continue;
			TreeLinkNode newNode = new TreeLinkNode(Integer.parseInt(nstr[i]));
			nodes.add(newNode);
			TreeLinkNode par = nodes.get(count / 2);
			if (count % 2 == 0)
				par.left = newNode;
			else
				par.right = newNode;
		}
		return nodes.get(0);
	}

	private void intraverse(TreeLinkNode root) {
		if (root == null)
			return;
		intraverse(root.left);
		System.out.print(root.val + " ");
		intraverse(root.right);
	}

	private void pretraverse(TreeLinkNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		pretraverse(root.left);
		pretraverse(root.right);
	}

	public static void main(String[] args) {
		Populating_Next_Right_Pointers_in_Each_Node_II p = new Populating_Next_Right_Pointers_in_Each_Node_II();
		TreeLinkNode root = p.createTree();
		p.connect(root);
		while (root != null) {
			TreeLinkNode node = root;
			while (node != null) {
				System.out.print(node.val + " ");
				node = node.next;
			}
			System.out.println();
			root = root.left;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> nodes = new LinkedList<TreeLinkNode>();
		Queue<Integer> levels = new LinkedList<Integer>();
		nodes.offer(root);
		levels.offer(0);
		int curLevel = -1;
		TreeLinkNode curNode = null;
		while (!nodes.isEmpty()) {
			TreeLinkNode node = nodes.poll();
			int level = levels.poll();
			if (curLevel != level) {
				curLevel = level;
				curNode = node;
			} else {
				curNode.next = node;
				curNode = node;
			}
			if (node.left != null) {
				nodes.offer(node.left);
				levels.offer(level + 1);
			}
			if (node.right != null) {
				nodes.offer(node.right);
				levels.offer(level + 1);
			}
		}
	}
}
