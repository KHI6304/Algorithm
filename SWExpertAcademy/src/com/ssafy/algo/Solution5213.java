package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sum = new long[1000001];
		sumOdd();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long sol = sum[R] - sum[L - 1];
				
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static long[] sum;
	static void sumOdd() {
		for(int i = 1; i <= 1000000; i += 2)
			for(int j = 1; i * j <= 1000000; j++)
				sum[i * j] += i;
		
		for(int i = 1; i < 1000000; i++)
			sum[i + 1] += sum[i];
	}
}