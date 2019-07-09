package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringBuilder sb = new StringBuilder();
			String inp = br.readLine();
			
			sb.append(inp.charAt(0));
			String tmp = sb.toString();
			for(int i = 1; i < 10; i++) {
				if( inp.substring(i, i + tmp.length()).equals(tmp) )
					break;
				sb.append(inp.charAt(i));
				tmp = sb.toString();
			}
			
			System.out.println("#" + testCase + " " + tmp.length());
		}
	}
}