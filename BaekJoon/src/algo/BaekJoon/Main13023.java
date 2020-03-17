package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main13023 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		list = new ArrayList[N];
		for(int i = 0; i < N; i++)
			list[i] = new ArrayList<>();
					
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		sol = 0;
		for(int i = 0; i < N; i++)
			DFS(i, 0);
		
		System.out.println(sol);
	}
	
	private static int N, M;
	private static ArrayList<Integer>[] list;
	private static boolean[] visited;
	private static int sol;
	
	private static void DFS(int num, int depth) {
		if(depth == 4) {
			sol = 1;
			return;
		}
		if(sol == 1)
			return;
		
		visited[num] = true;
		for(int i = 0; i < list[num].size(); i++) {
			int tmp = list[num].get(i);
			
			if(visited[ tmp ]) continue;
			
			DFS(tmp, depth + 1);
		}
		visited[num] = false;
	}
}