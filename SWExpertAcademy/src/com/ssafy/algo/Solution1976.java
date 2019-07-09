package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1976 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			h += Integer.parseInt(st.nextToken());
			m += Integer.parseInt(st.nextToken());
			
			h += m / 60;
			m %= 60;
			h %= 12;
			if(h % 12 == 0) h = 12;
			
			System.out.println("#" + testCase + " " + h + " " + m);
		}
	}
}