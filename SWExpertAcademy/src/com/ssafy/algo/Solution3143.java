package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3143 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			int cnt = 0;
			
			for(int i = 0; i < A.length(); i++) {
				
				boolean flag = true;
				for(int j = 0; j < B.length() && flag; j++) {
					if(i + j >= A.length()) {
						flag = false;
						break;
					}
					
					if(A.charAt(i + j) != B.charAt(j))
						flag = false;
				}
				
				if(flag) {
					cnt++;
					i += B.length() - 1;
				}
			}
			
			System.out.println("#" + tc + " " + (A.length() - B.length() * cnt + cnt) );
		}
	}
}