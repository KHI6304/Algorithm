package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			String forward = br.readLine();
			String backward = new StringBuffer(forward).reverse().toString();
			
			if(forward.equals(backward))
				System.out.println("#" + testCase + " 1");
			else
				System.out.println("#" + testCase + " 0");
		}
	}
}