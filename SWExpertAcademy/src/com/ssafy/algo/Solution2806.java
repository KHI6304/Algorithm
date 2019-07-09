package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2806 {
	static int N;
	static int[] cols;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cols = new int[N];
			
			ans = 0;
			nQueen(0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static int ans;
	static void nQueen(int line) {
		if(line == cols.length) {
			ans++;
			return;
		}
		
		for(int i = 0; i < cols.length; i++) {
			cols[line] = i;
			if(isOk(line))
				nQueen(line + 1);
		}
	}
	
	static boolean isOk(int line) {
		for(int i = 0; i < line; i++)
			if(cols[line] == cols[i] || Math.abs(line - i) == Math.abs(cols[line] - cols[i]))
				return false;
		return true;
	}
}