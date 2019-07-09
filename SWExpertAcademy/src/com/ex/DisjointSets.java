package com.ex;

import java.util.Arrays;

public class DisjointSets {
	static int[] parents;
	static int[] rank;
	
	public static void main(String[] args) {
		parents = new int[6];
		rank = new int[6];
		for(int i = 0; i < parents.length; i++)
			makeSet(i);
		
		union(0, 1);
		System.out.println(Arrays.toString(parents));
		union(2, 3);
		System.out.println(Arrays.toString(parents));
		union(0, 3);
		System.out.println(Arrays.toString(parents));
		union(4, 5);
		System.out.println(Arrays.toString(parents));
		union(2, 4);
		System.out.println(Arrays.toString(parents));
	}
	
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