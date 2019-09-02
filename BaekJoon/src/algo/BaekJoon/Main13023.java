package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13023 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		
		for(int i = 0; i < N; i++) {
			if( DFS(i, 1) ) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}
	
	static private int[][] map;
	static private boolean[] visited;
	
	private static boolean DFS(int n, int depth) {
		if(depth == 5)
			return true;
		
		visited[n] = true;
		for(int i = 0; i < map.length; i++) {
			if(map[n][i] == 1 && !visited[i]) {
				visited[i] = true;
				if( DFS(i, depth + 1) )
					return true;
			}
		}
		
		visited[n] = false;
		return false;
	}
}