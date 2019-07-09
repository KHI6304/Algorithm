package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n + 1][n + 1];
		int[][] dp = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j = 1; j <= i; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= i; j++)
				dp[i][j] = map[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
		
		int max = 0;
		for(int i = 1; i <= n; i++)
			max = Math.max(dp[n][i], max);
		
		System.out.println(max);
	}
}