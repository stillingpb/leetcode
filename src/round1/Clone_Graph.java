package round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Clone_Graph {
	static class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}

		public String toString() {
			return "" + label;
		}
	};

	private void printGraph(UndirectedGraphNode node,
			HashSet<UndirectedGraphNode> visited) {
		System.out.println(node.label + ": " + node.neighbors);
		visited.add(node);
		for (UndirectedGraphNode nei : node.neighbors) {
			if (visited.contains(nei))
				continue;
			printGraph(nei, visited);
		}
	}

	public static void main(String[] args) {
		UndirectedGraphNode n0 = new UndirectedGraphNode(0);
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		n0.neighbors.add(n1);
		n0.neighbors.add(n2);
		n1.neighbors.add(n0);
		n1.neighbors.add(n2);
		n2.neighbors.add(n0);
		n2.neighbors.add(n1);
		n2.neighbors.add(n2);
		Clone_Graph c = new Clone_Graph();
		c.printGraph(n0, new HashSet<UndirectedGraphNode>());
		UndirectedGraphNode copy = c.cloneGraph(n0);
		c.printGraph(copy, new HashSet<UndirectedGraphNode>());
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		traverse(node, map);
		copyTraverse(node, map, new HashSet<UndirectedGraphNode>());
		return map.get(node);
	}

	private void copyTraverse(UndirectedGraphNode node,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map,
			HashSet<UndirectedGraphNode> visited) {
		// copy
		UndirectedGraphNode copyNode = map.get(node);
		for (UndirectedGraphNode nei : node.neighbors) {
			UndirectedGraphNode copyNei = map.get(nei); // copy neighber
			copyNode.neighbors.add(copyNei);
		}
		// traverse
		visited.add(node);
		for (UndirectedGraphNode nei : node.neighbors) {
			if (visited.contains(nei))
				continue;
			copyTraverse(nei, map, visited);
		}
	}

	private void traverse(UndirectedGraphNode node,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		map.put(node, new UndirectedGraphNode(node.label));
		for (UndirectedGraphNode nei : node.neighbors) {
			if (map.containsKey(nei))
				continue;
			traverse(nei, map);
		}
	}

}
