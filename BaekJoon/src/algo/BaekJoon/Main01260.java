package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main01260 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		
		visited = new boolean[N + 1];
		DFS();
		
		System.out.println();
		
		visited = new boolean[N + 1];
		BFS();
	}
	
	private static int N;
	private static int M;
	private static int V;
	private static int[][] map;
	private static boolean[] visited;
	
	private static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		visited[V] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			System.out.print(tmp + " ");
			
			for(int i = 1; i <= N; i++) {
				if(map[tmp][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	private static void DFS() {
		Stack<Integer> s = new Stack<>();
		s.push(V);
		
		while(!s.isEmpty()) {
			int tmp = s.pop();
			
			if(!visited[tmp]) {
				System.out.print(tmp + " ");
				visited[tmp] = true;
				
				for(int i = map.length - 1; i > 0; i--)
					if(!visited[i] && map[tmp][i] == 1)
						s.push(i);
			}
		}
	}
}