package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		ans = Integer.MAX_VALUE;
		visited = new boolean[N];
		DFS(0, 0);
		System.out.println(ans);
	}
	
	private static int N;
	private static int[][] map;
	private static boolean[] visited;
	private static int ans;
	
	private static void DFS(int depth, int idx) {
		if(depth == N / 2) {
			int sumA = 0;
			int sumB = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					if(visited[i] && visited[j])
						sumA += map[i][j] + map[j][i];
					
					if(!visited[i] && !visited[j])
						sumB += map[i][j] + map[j][i];
				}
			}
			ans = Math.min(ans, Math.abs(sumA - sumB));
			return;
		}
		
		for(int i = idx; i < N; i++) {
			visited[i] = true;
			DFS(depth + 1, i + 1);
			visited[i] = false;
		}
	}
}