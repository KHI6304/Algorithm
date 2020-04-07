package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01003 {
	private static class Node {
		int zero, one;

		public Node(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}

		@Override
		public String toString() {
			return zero + " " + one;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node[] dp = new Node[41];
		dp[0] = new Node(1, 0);
		dp[1] = new Node(0, 1);
		
		for(int i = 2; i < dp.length; i++)
			dp[i] = new Node(dp[i - 2].zero + dp[i - 1].zero, dp[i - 2].one + dp[i - 1].one);
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int num = Integer.parseInt(br.readLine());
			
			System.out.println(dp[num]);
		}
	}
}