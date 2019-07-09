package jungol.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1350 {
	static class Edge implements Comparable<Edge> {
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
			return o.w - w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parents = new int[N + 1];
		rank = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
			makeSet(i);
		
		Edge[] es = new Edge[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			es[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(es);
		
		int sum = 0;
		for (int i = 0; i < M; i++) {
			if (findSet(es[i].n1) != findSet(es[i].n2)) {
				union(es[i].n1, es[i].n2);
				sum += es[i].w;
			}
		}
		
		System.out.println(sum);
	}
	
	static int[] parents;
	static int[] rank;
	
	static void makeSet(int n) {
		parents[n] = n;
	}
	
	static int findSet(int n) {
		if(parents[n] == n)
			return n;
		
		return parents[n] = findSet(parents[n]);
	}
	
	static void union(int n1, int n2) {
		int pn1 = findSet(n1);
		int pn2 = findSet(n2);
		
		if(rank[pn1] > rank[pn2]) {
			parents[pn2] = pn1;
		}
		else {
			parents[pn1] = pn2;
			if(rank[pn1] == rank[pn2])
				rank[pn2]++;
		}
	}
}