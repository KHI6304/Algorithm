package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < nums.length; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		
		solve(new int[M], 0);
		
		System.out.println(sb);
	}
	
	private static int N;
	private static int M;
	private static int[] nums;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();
	
	private static void solve(int[] arr, int depth) {
		if(depth == M) {
			for(int i = 0; i < arr.length; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			arr[depth] = nums[i];
			visited[i] = true;
			solve(arr, depth + 1);
			visited[i] = false;
		}
	}
}