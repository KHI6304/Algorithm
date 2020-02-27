package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15663 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inps = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			inps[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(inps);
		solve(new int[M], 0);
		System.out.println(sb);
	}
	
	private static int N, M;
	private static int[] inps;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();
	
	private static void solve(int[] arr, int depth) {
		if(depth == M) {
			for(int n : arr)
				sb.append(n + " ");
			sb.append("\n");
			
			return;
		}
		
		int before = -1;
		for(int i = 0; i < N; i++) {
			if(visited[i] || before == inps[i]) continue;
			
			arr[depth] = inps[i];
			before = inps[i];
			visited[i] = true;
			solve(arr, depth + 1);
			visited[i] = false;
		}
	}
}