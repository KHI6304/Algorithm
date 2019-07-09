package algo.BaekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01158 {
	static class Node {
		int data;
		Node link;

		public Node(int data, Node link) {
			this.data = data;
			this.link = link;
		}
	}
	
	static class LinkedQueue {
		private Node front;
		private Node rear;
		
		public LinkedQueue() {
			front = null;
			rear = null;
		}
		
		public void Enqueue(int data) {
			Node node = new Node(data, null);
			if(isEmpty()) {
				front = node;
				rear = node;
			}
			else {
				rear.link = node;
				rear = node;
			}
			
		}

		public int Dequeue() {
			if(isEmpty())
				return -1;
			else {
				int data = front.data;
				front = front.link;
				return data;
			}
		}

		public boolean isEmpty() {
			return front == null;
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		LinkedQueue queue = new LinkedQueue();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= N; i++)
			queue.Enqueue(i);
		
		int cnt = 0;
		while(!queue.isEmpty())
			if(++cnt % M == 0)
				list.add(queue.Dequeue());
			else
				queue.Enqueue(queue.Dequeue());
		
		System.out.print("<");
		for(int i = 0; i < list.size() - 1; i++)
			System.out.print(list.get(i) + ", ");
		System.out.print(list.get(list.size() - 1) + ">");
	}
}