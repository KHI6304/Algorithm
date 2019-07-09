package com.ex;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {
	static class Edge implements Comparable<Edge>{
		int n1;
		int n2;
		int w;
		
		public Edge(int n1, int n2, int w) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return w - o.w;
		}

		@Override
		public String toString() {
			return n1 + " - " + n2 + " : " + w;
		}
	}
	
	public static void main(String[] args) {
			Scanner sc = new Scanner("7 11\n"
					+ "0 1 31\r\n"
					+ "0 2 31\r\n"
					+ "0 6 31\r\n"
					+ "0 5 60\r\n"
					+ "1 2 21\r\n"
					+ "2 4 46\r\n"
					+ "2 6 25\r\n"
					+ "3 4 34\r\n"
					+ "4 6 51\r\n"
					+ "5 3 18\r\n"
					+ "5 4 40\r\n");
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			Edge[] es = new Edge[E];
			for(int i = 0; i < E; i++)
				es[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
			
			Arrays.sort(es);
			for(Edge e : es)
				System.out.println(e);
			
			parents = new int[V];
			rank = new int[V];
			
			for(int i = 0; i < V; i++)
				makeSet(i);
			
			int sum = 0;
			for(int i = 0; i < es.length; i++) {
				if(findSet(es[i].n1) != findSet(es[i].n2)) {
					union(es[i].n1, es[i].n2);
					sum += es[i].w;
				}
			}
			System.out.println("\n\n최소신장 비용 : " + sum);
	}
	
	static int[] parents;
	static int[] rank;
	
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
		
		if(rank[px] > rank[py])
			parents[py] = px;
		else {
			parents[px] = py;
			if(rank[px] == rank[py])
				rank[py]++;
		}
	}
}