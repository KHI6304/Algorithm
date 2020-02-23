package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		DFS(new int[M], 0);
		System.out.println(sb);
	}
	
	private static int N;
	private static int M;
	private static StringBuilder sb;
	
	private static void DFS(int[] arr, int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			arr[depth] = i;
			DFS(arr, depth + 1);
		}
	}
}