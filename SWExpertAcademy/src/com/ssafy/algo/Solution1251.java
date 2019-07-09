package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;
 
public class Solution1251 {
    static class Island {
        long x;
        long y;
    }
 
    static class Edge implements Comparable<Edge> {
        int i1;
        int i2;
        double distance;
         
        public Edge(int i1, int i2, double d) {
            this.i1 = i1;
            this.i2 = i2;
            this.distance = d;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Double.compare(distance, o.distance);
        }

		@Override
		public String toString() {
			return i1 + " - " + i2 + " : " + distance;
		}
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            Island[] is = new Island[N];
             
            for (int i = 0; i < N; i++) {
                is[i] = new Island();
                is[i].x = sc.nextLong();
            }
             
            for (int i = 0; i < N; i++)
                is[i].y = sc.nextLong();
             
            double E = sc.nextDouble();
 
            parents = new int[N];
            rank = new int[N];
            int size = 0;
            for (int i = 0; i < N; i++) {
                makeSet(i);
                size += i;
            }
            
            Edge[] es = new Edge[size];
            int idx = -1;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                	double dis_x = Math.pow(is[i].x - is[j].x, 2);
                	double dis_y = Math.pow(is[i].y - is[j].y, 2);
                	double dis = Math.sqrt(dis_x + dis_y);
                	double pow = Math.pow(dis, 2);
                    es[++idx] = new Edge(i, j, pow * E);
                }
            }
 
            Arrays.sort(es);
            
            double sum = 0;
            for (int i = 0; i < es.length; i++) {
                if (findSet(es[i].i1) != findSet(es[i].i2)) {
                    union(es[i].i1, es[i].i2);
                    sum += es[i].distance;
                }
            }
 
            System.out.println("#" + tc + " " + Math.round(sum));
        }
    }

    
    static int[] parents;
    static int[] rank;
    
    static void makeSet(int x) {
        parents[x] = x;
    }
 
    static int findSet(int x) {
        if (parents[x] == x)
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