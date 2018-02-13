package com.learning;

public class SearchNode {
	private String data;
	private SearchNode leftNode;
	private SearchNode rightNode;

	public SearchNode(String data, SearchNode leftNode, SearchNode rightNode) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public String getData() {
		return data;
	}

	public SearchNode getLeftNode() {
		return leftNode;
	}

	public SearchNode getRightNode() {
		return rightNode;
	}

	public SearchNode(String data) {
		this.data = data;
	}

	public SearchNode() {
		
	}
	
	
	

}
