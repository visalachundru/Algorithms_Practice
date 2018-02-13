package com.learning;

import java.util.LinkedList;

public class LinkedListExercises {

	private Node head;

	static class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

	}

	public static void main(String[] args) {
		//5--> 8--> 10--> 12 --> 6		
		printOddNodesMiddle();
		
		//5--> 8--> 10--> 12 --> 6 -->16
		printEvenNodesMiddle();
		
		printIfThereIsACyclic();

	}

	private static void printEvenNodesMiddle() {
		LinkedList<Node> list = new LinkedList<Node>();

		Node head = new Node(5);
		Node second = new Node(8);
		Node third = new Node(10);
		Node fourth = new Node(12);
		Node fifth = new Node(6);
		Node sixth = new Node(16);


		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		
		list.addLast(head);
		list.addLast(second);
		list.addLast(third);
		list.addLast(fourth);
		list.addLast(fifth);
		
		Node middleElement = findMiddleElement(list);
		System.out.println("Middle element value of the Even Nodes is:" + middleElement.value);

	}

	private static void printOddNodesMiddle() {
		LinkedList<Node> list = new LinkedList<Node>();

		Node head = new Node(5);
		Node second = new Node(8);
		Node third = new Node(10);
		Node fourth = new Node(12);
		Node fifth = new Node(6);
		
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		list.addLast(head);
		list.addLast(second);
		list.addLast(third);
		list.addLast(fourth);
		list.addLast(fifth);
		
		Node middleElement = findMiddleElement(list);
		System.out.println("Middle element value of the Odd Nodes is:" + middleElement.value);

	}

	private static Node findMiddleElement(LinkedList<Node> list) {
		Node pointer1, pointer2;
		pointer1 = list.getFirst();
		pointer2 = list.getFirst();
		while (pointer1 != null && pointer1.next != null) {
			pointer2 = pointer2.next;
			pointer1 = pointer1.next.next;
		}

		return pointer2;
	}
	
	static void printIfThereIsACyclic() {
		LinkedList<Node> list = new LinkedList<Node>();

		Node head = new Node(5);
		Node second = new Node(8);
		Node third = new Node(10);
		Node fourth = new Node(12);
		Node fifth = new Node(6);
		
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = second;
		
		
		Node fast = head;
		Node slow = head;
	    while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow)
			{
				System.out.println("there is a cyclic : " +  fast.value);
			}
		}
		
	}

}
