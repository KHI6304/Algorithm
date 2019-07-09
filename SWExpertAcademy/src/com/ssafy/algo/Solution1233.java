package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1233 {
	
	static StringBuilder sb;
	static int N;
	
	static class BinaryTree {
		String[] tree;
		private int root = 1;
		
		public BinaryTree(int nodeNum) {
			tree = new String[nodeNum + 1];
		}
		
		public void inorder_traverse(int root){
			if(root > N)
				return;
			
			inorder_traverse(root * 2);
			sb.append(tree[root]);
			inorder_traverse(root * 2 + 1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			N = Integer.parseInt(br.readLine());
			BinaryTree bt = new BinaryTree(N);
			
			sb = new StringBuilder();
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String s = st.nextToken();
				bt.tree[i] = s;
			}
			
			bt.inorder_traverse(1);
			String s = sb.toString();
			
			boolean flag = true;
			for(int i = 0; i < s.length() - 1 && flag; i++) {
				int c = s.charAt(i);
				int nextC = s.charAt(i + 1);
				if(c >= 48) {
					if(nextC >= 48)
						flag = false;
				}
				else {
					if(nextC < 48)
						flag = false;
				}
			}
			
			if(flag)
				System.out.printf("#%d 1%n", testCase);
			else
				System.out.printf("#%d 0%n", testCase);
		}
	}
}