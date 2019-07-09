package com.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PriorityQueuePrim {
	static class Node implements Comparable<Node> {
		int dest;	// 도착지
		int cost;
		Node(int _dest, int _cost) {
			dest = _dest;
			cost = _cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			ArrayList<Node>[] adj = new ArrayList[V + 1];
			for(int i = 1; i <= V; i++)
				adj[i] = new ArrayList<>();
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				adj[a].add(new Node(b, c));
				adj[b].add(new Node(a, c));
			}
			boolean[] visited = new boolean[V + 1];
			PriorityQueue<Node> queue = new PriorityQueue<>();
			
			visited[1] = true;
			queue.addAll(adj[1]);
			
			long cnt = 0;
			long sum = 0;
			while( !queue.isEmpty() ) {
				if(cnt == V)
					break;
				
				Node node = queue.poll();
				if( visited[node.dest] )
					continue;
				
				// 방문한적이 없으면 가중치를 누적합하고 해당 정점을 방문체크, 그리고 그 정점으로 출발하는 모든 간선 큐에 삽입
				sum += node.cost;
				queue.addAll(adj[node.dest]);
				visited[node.dest] = true;
				
				cnt++;
			}
			bw.write("#" + tc + " " + sum + "\n");
			
//			// 간선의 정보는 인접행렬에 저장
//			int[][] adj = new int[V][V];
//			for(int i = 0; i < E; i++) {
//				st = new StringTokenizer(br.readLine());
//				int a = Integer.parseInt(st.nextToken());
//				int b = Integer.parseInt(st.nextToken());
//				int c = Integer.parseInt(st.nextToken());
//				
//				adj[a][b] = c;
//				adj[b][a] = c;
//			}
//			
//			boolean[] visited = new boolean[V];
//			PriorityQueue<Node> queue = new PriorityQueue<>();
//			
//			visited[0] = true;
//			for(int i = 0; i < V; i++) {
//				if(adj[0][i] != 0)
//					queue.add(new Node(i, adj[0][i]));
//			}
//			
//			int cnt = 0;
//			int sum = 0;
//			while( !queue.isEmpty() ) {
//				if(cnt == V)
//					break;
//				
//				Node node = queue.poll();
//				if( visited[node.dest] )
//					continue;
//				
//				// 방문한적이 없으면 가중치를 누적합하고 해당 정점을 방문체크, 그리고 그 정점으로 출발하는 모든 간선 큐에 삽입
//				sum += node.cost;
//				for(int i = 0; i < V; i++) {
//					if(adj[node.dest][i] != 0)
//						queue.add(new Node(i, adj[node.dest][i]));
//				}
//				visited[node.dest] = true;
//				
//				cnt++;
//			}
//			System.out.println(sum);
		}
		bw.close();
	}
}