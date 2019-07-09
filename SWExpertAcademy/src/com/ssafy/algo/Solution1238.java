package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1238 {
	static class Node implements Comparable<Node> {
		int num;
		int cnt;
		
		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(cnt - o.cnt == 0)
				return num - o.num;
			return cnt - o.cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			map = new int[101][101];
			visited = new boolean[101];
			ns = new Node[101];
			
			for(int i = 0; i < 101; i++)
				ns[i] = new Node(i, 0);
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < (len / 2); i++) {
				int startIdx = Integer.parseInt(st.nextToken());
				int endIdx = Integer.parseInt(st.nextToken());
				
				map[startIdx][endIdx] = 1;
			}
			
			BFS();
			Arrays.sort(ns);
			System.out.println("#" + tc + " " + ns[100].num);
		}
	}
	
	static int len;
	static int start;
	static int Index;
	static int[][] map;
	static boolean[] visited;
	static Node[] ns;
	static void BFS() {
		Queue<Node> q = new LinkedList<>();
		q.add(ns[start]);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			int num = tmp.num;
			int cnt = tmp.cnt;
			
			for(int i = 1; i < 101; i++) {
				if(map[num][i] == 1 && !visited[i]) {
					ns[i].cnt = cnt + 1;
					q.add(ns[i]);
					visited[i] = true;
				}
			}
		}
	}
}