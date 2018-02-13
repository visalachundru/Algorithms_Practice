package com.learning;

import java.util.LinkedList;
import java.util.Queue;

public class BfsAndDfsExercise {

	private Node head;

	static class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

	}

	public static void main(String[] args) {
		SearchNode tree = createSampleTree();
		System.out.println("Nodes in Bfs are: ");
		traverseBfs(tree);
		System.out.println("Nodes in Dfs are: ");
		traverseDfs(tree);

	}

	// Last in first out.
	private static void traverseDfs(SearchNode tree) {
		if (tree == null)
			return;
		System.out.println(tree.getData());
		traverseDfs(tree.getLeftNode());
		traverseDfs(tree.getRightNode());

	}

	// First in First out
	private static void traverseBfs(SearchNode tree) {
		Queue<SearchNode> queue = new LinkedList<SearchNode>();
		queue.add(tree);
		while (!queue.isEmpty()) {
			SearchNode node = queue.remove();
			System.out.println(node.getData());
			if (node.getLeftNode() != null) {
				queue.add(node.getLeftNode());
			}
			if (node.getRightNode() != null) {
				queue.add(node.getRightNode());
			}
		}

	}

	private static SearchNode createSampleTree() {
		SearchNode cNode = new SearchNode("C");
		SearchNode dNode = new SearchNode("D");
		SearchNode hNode = new SearchNode("H");
		SearchNode fNode = new SearchNode("F");
		SearchNode gNode = new SearchNode("G", hNode, null);
		SearchNode eNode = new SearchNode("E", fNode, gNode);
		SearchNode bNode = new SearchNode("B", cNode, dNode);
		SearchNode aNode = new SearchNode("A", bNode, eNode);
		return aNode;

	}

}
