package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution2071 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				sum += num;
			}
			
			int avg = (int) Math.round(sum / 10.0);
			System.out.println("#" + tc + " " + avg);
		}
	}
}