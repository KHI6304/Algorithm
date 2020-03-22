package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		int[][] dp = new int[2][N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < N; j++)
				if(arr[i] > arr[j])
					dp[0][i] = Math.max(dp[0][i], dp[0][j]);
			
			dp[0][i] += 1;
		}
		
		for(int i = N - 1; i >= 0; i--) {
			for(int j = N - 1; j > i; j--)
				if(arr[i] > arr[j])
					dp[1][i] = Math.max(dp[1][i], dp[0][j]);
			
			dp[1][i] += 1;
		}
		
		int sol = 0;
		for(int i = 0; i < N; i++)
			sol = Math.max(sol, dp[0][i] + dp[1][i]);
		
		System.out.println(sol - 1);
	}
}