package jungol.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class JUNGOL1863 {
	static class Edge {
		int n1;
		int n2;
		
		public Edge(int n1, int n2) {
			this.n1 = n1;
			this.n2 = n2;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 노드 수
		int M = Integer.parseInt(st.nextToken());	// 간선 수
		
		list = new LinkedList[N + 1];
		visited = new boolean[N + 1];
		Edge[] es = new Edge[M];
		
		for(int i = 1; i <= N; i++)
			list[i] = new LinkedList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			es[i] = new Edge(n1, n2);
			
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		cnt = 0;
		q = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			int n1 = es[i].n1;
			int n2 = es[i].n2;
			
			if(!visited[n1] && !visited[n2]) {
				q.add(n1);
				q.add(n2);
				visited[n1] = true;
				visited[n2] = true;
				BFS();
				cnt++;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				cnt++;
				visited[i] = true;
			}
		}
		System.out.println(cnt);
	}
	
	static List<Integer>[] list;
	static boolean[] visited;
	static Queue<Integer> q;
	static int cnt;
	static int N;
	static void BFS() {
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && list[tmp].contains(i)) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}