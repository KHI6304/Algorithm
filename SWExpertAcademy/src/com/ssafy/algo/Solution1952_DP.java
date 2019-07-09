package com.ssafy.algo;

import java.util.Scanner;

public class Solution1952_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int[] price = new int[4];
			for(int i = 0; i < 4; i++)
				price[i] = sc.nextInt();
			int[] plan = new int[12];
			for(int i = 0; i < 12; i++)
				plan[i] = sc.nextInt();
			int[] dp = new int[13];
			for(int i = 1; i < 13; i++) {
				dp[i] = Math.min(dp[i-1] + plan[i-1] * price[0] , dp[i-1] + price[1]);
				if( i>= 3 )
					dp[i] = Math.min(dp[i-3] + price[2], dp[i]);
			}
			int result = Math.min(dp[13], price[3]);
			System.out.println(result);
		}
	}
}
