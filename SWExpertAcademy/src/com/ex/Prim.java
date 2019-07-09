package com.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Prim {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			// 간선의 정보는 인접행렬에 저장
			int[][] adj = new int[V + 1][V + 1];
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				adj[a][b] = c;
				adj[b][a] = c;
			}
			
			// ArrayList를 하나 준비해서 이곳에 방문해서 내편이 된 정점을 답을겁니다.
			ArrayList<Integer> list = new ArrayList<>();
			// 방문배열 생성
			boolean[] visited = new boolean[V];
			
			// 첫번째 0번 노드를 방문함 -> 0을 ArrayList에 담고, 방문체크
			list.add(0);
			visited[0] = true;
			
			// list에 있는 모든 정점을 출발지로 한 간선 중에
			// 방문하지 않았으면서 가중치가 최소인 간선을 찾아 가중치를 누적합하고 도착정점을 list에 추가
			int sum = 0;
			for(int i = 0; i < V - 1; i++) {
				int min = Integer.MAX_VALUE;
				int minIdx = 0;
				
				for(int start : list) {
					for(int j = 0; j < V; j++) {
						// adj[start][j] 들 중 젤 작은놈 찾아라
						// 위 값이 경로가 있으면서 지금까지중의 최소값이면서 방문한적 없긔
						if(adj[start][j] != 0 && min > adj[start][j] && !visited[j]) {
							min = adj[start][j];
							minIdx = j;
						}
					}
				}
				list.add(minIdx);
				sum += min;
				visited[minIdx] = true;
			}
		}
	}
}