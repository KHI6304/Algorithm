package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution4672 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			String[] arr = str.split("");
			Arrays.sort(arr);
			
			String sortStr = String.join("", arr);
			sol = sortStr.length();
			
			solve(sortStr);
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int sol;
	static boolean isPelindrome(String str) {
		String strReverse = new StringBuffer(str).reverse().toString();
		
		return str.equals(strReverse);
	}
	
	static void solve(String str) {
		for(int i = 1; i <= str.length() - 1; i++) {
			int start = 0;
			int end = i;
			while(end < str.length()) {
				String tmp = str.substring(start, end + 1);
				if(isPelindrome(tmp))
					sol++;
				start++;
				end++;
			}
		}
	}
}