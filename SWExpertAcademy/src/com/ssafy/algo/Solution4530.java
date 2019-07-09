package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4530 {
	static long switchNum(long num) {
		num = Math.abs(num);
		long returnNum = 0;
		long tmp = num;
		int cnt = 0;
		
		while(tmp > 0) {
			int n = (int) (tmp % 10);
			tmp /= 10;
			if(n > 3)
				n -= 1;
			returnNum += n * Math.pow(10, cnt++);
		}
		
		return returnNum;
	}
	
	static long NineSystem(long num) {
		long swNum = switchNum(num);
		long returnNum = 0;
		int cnt = 0;
		
		while(swNum > 0) {
			int n = (int) (swNum % 10);
			swNum /= 10;
			returnNum += n * Math.pow(9, cnt++);
		}
		
		return returnNum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			long solA = NineSystem(A);
			long solB = NineSystem(B);
			
			long sol;
			if(A > 0 && B > 0)
				sol = solB - solA;
			else if(A < 0 && B < 0)
				sol = solA - solB;
			else
				sol = solB + solA - 1;
				
			sb.append("#").append(tc).append(" ").append(sol).append("\n");
		}
		System.out.print(sb);
	}
}