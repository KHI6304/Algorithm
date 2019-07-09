package com.ssafy.algo;

import java.util.Scanner;

public class Solution1228 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			LinkedList list = new LinkedList();

			int N = sc.nextInt();
			for(int i = 0; i < N; i++)
				list.add(sc.nextInt());
			
			N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				sc.next();
				int index = sc.nextInt();
				int num = sc.nextInt();
				
				for(int j = 0; j < num; j++)
					list.add(sc.nextInt(), index++);
			}
			
			System.out.printf("#%d ", testCase);
			System.out.println(list.toString());
		}
	}
}

class LinkedList {
	private Node head;
	private int size;
	
	public String toString() {
		// 모든 노드들의 data를 문자열로 연결해서 리턴
		StringBuilder sb = new StringBuilder();
		
		Node tmp = head;
		for(int i = 0; i < 10; i++) {
			sb.append(tmp.data).append(" ");
			tmp = tmp.link;
		}
		
		return sb.toString();
	}
	
	public void add(int data, int idx) {
		// idx 번째 노드의 다음위치에 새로운 노드를 추가해 보세요
		Node tmp = head;
		Node node = new Node();
		node.data = data;
		
		if(idx == 0) {
			node.link = head;
			head = node;
			return;
		}
		
		for(int i = 1; i < idx && tmp.link != null; i++)
			tmp = tmp.link;
		
		node.link = tmp.link;
		tmp.link = node;
	}
	
	public void add(int data) {
		// 맨 뒤에 추가
		Node node = new Node();
		node.data = data;
		Node tmp = head;
		
		if(head == null) {
			head = node;
		}
		else {
			while(tmp.link != null) {
				tmp = tmp.link;
			}
			tmp.link = node;
		}
		size++;
	}
}

class Node {
	public int data;
	public Node link;
}