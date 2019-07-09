package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3124 {
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
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			Edge[] es = new Edge[E];
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				es[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(es);
			
			parents = new int[V + 1];
			rank = new int[V + 1];
			
			for(int i = 0; i < V; i++)
				makeSet(i);
			
			long sum = 0;
			for(int i = 0; i < es.length; i++) {
				if(findSet(es[i].n1) != findSet(es[i].n2)) {
					union(es[i].n1, es[i].n2);
					sum += es[i].w;
				}
			}
			
			System.out.println("#" + tc + " " + sum);
		}
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