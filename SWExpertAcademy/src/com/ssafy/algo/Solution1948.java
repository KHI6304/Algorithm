package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1948 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int xMonth = Integer.parseInt(st.nextToken());
			int xDay = Integer.parseInt(st.nextToken());
			int yMonth = Integer.parseInt(st.nextToken());
			int yDay = Integer.parseInt(st.nextToken());
			
			int sol = 0;
			int tmp = xMonth;
			if(yMonth - xMonth == 0) {
				sol = yDay - xDay + 1;
			}
			else {
				for(int i = 0; i <= yMonth - xMonth; i++) {
					if(i == yMonth - xMonth)
						sol += yDay;
					else if(i == 0)
						sol += month[tmp] - xDay + 1;
					else
						sol += month[tmp];
					tmp++;
				}
			}
				
			
			System.out.println("#" + testCase + " " + sol);
		}
	}
}