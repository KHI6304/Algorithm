package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11722 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		int sol = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < i; j++)
				if(arr[i] < arr[j])
					dp[i] = Math.max(dp[i], dp[j]);
			
			dp[i] += 1;
			sol = Math.max(sol, dp[i]);
		}
		
		System.out.println(sol);
	}
}