package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15664 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		solve(new int[M], 0, 0);
		System.out.println(sb);
	}
	
	private static int N, M;
	private static int[] nums;
	private static StringBuilder sb = new StringBuilder();
	
	private static void solve(int[] arr, int idx, int depth) {
		if(depth == M) {
			for(int n : arr)
				sb.append(n + " ");
			sb.append("\n");
			
			return;
		}
		
		int before = -1;
		for(int i = idx; i < N; i++) {
			if(before == nums[i]) continue;
			
			arr[depth] = nums[i];
			before = nums[i];
			solve(arr, i + 1, depth + 1);
		}
	}
}