package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[9];
		sb = new StringBuilder();
		solve(new int[M], 0);
		System.out.println(sb);
	}
	
	private static int N;
	private static int M;
	private static boolean[] visited;
	private static StringBuilder sb;
	
	private static void solve(int[] arr, int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			arr[depth] = i;
			visited[i] = true;
			solve(arr, depth + 1);
			visited[i] = false;
		}
	}
}