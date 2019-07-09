package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1952 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			price = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < price.length; i++)
				price[i] = Integer.parseInt(st.nextToken());
			
			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < plan.length; i++)
				plan[i] = Integer.parseInt(st.nextToken());
			
			ans = Integer.MAX_VALUE;
			solve(0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static int ans;
	static int[] price;
	static int[] plan;
	
	static void solve(int month, int sum) {
		if(month > 12)
			return;
		if(month == 12) {
			ans = Math.min(ans, sum);
			return;
		}
		
		// 1일 권
		solve(month + 1, sum + plan[month] * price[0]);
		// 한달권
		solve(month + 1, sum + price[1]);
		// 세달권
		solve(month + 3, sum + price[2]);
		// 1년권
		solve(month + 12, sum + price[3]);
	}
}