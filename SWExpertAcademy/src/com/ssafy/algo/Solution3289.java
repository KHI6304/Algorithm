package com.ssafy.algo;

import java.util.Scanner;

public class Solution3289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			parents = new int[n + 1];
			
			for(int i = 1; i <= n; i++)
				makeSet(i);
			
			for(int i = 0; i < m; i++) {
				int op = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(op == 0) {
					union(a, b);
				}
				else {
					if(findSet(a) != findSet(b))
						sb.append(0);
					else
						sb.append(1);
				}
			}
			
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
	
	static int[] parents;
	
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if(parents[x] == x)
			return x;
		
		parents[x] = findSet(parents[x]);
		return parents[x];
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		parents[py] = px;
	}
}