package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			String findStr = br.readLine();
			String inp = br.readLine();
			
			int idx = inp.indexOf(findStr);
			idx += findStr.length();
			int cnt = 1;
			while(inp.substring(idx).indexOf(findStr) != -1) {
				cnt++;
				idx = inp.substring(idx).indexOf(findStr) + inp.substring(0, idx).length();
				idx += findStr.length();
				if(idx >= inp.length())
					break;
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
}