package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main09095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[11];
		dp[0] = 1;
		
		for(int i = 0; i < 11; i++) {
			if(i - 1 >= 0)
				dp[i] += dp[i - 1];
			if(i - 2 >= 0)
				dp[i] += dp[i - 2];
			if(i - 3 >= 0)
				dp[i] += dp[i - 3];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(dp[n]);
		}
	}
}