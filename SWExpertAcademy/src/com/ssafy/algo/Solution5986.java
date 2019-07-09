package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution5986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		getPrimeNum();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int sol = 0;
			for(int i = 2; i <= N - 2; i++) {
				if(!primeNum[i])
					continue;
				for(int j = 2; j <= N - i - 2; j++) {
					int num3 = N - i - j;
					if(primeNum[j] && primeNum[num3] && i <= j && j <= num3)
						sol++;
				}
			}
			
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static boolean[] primeNum;
	static void getPrimeNum() {
		primeNum = new boolean[1000];
		Arrays.fill(primeNum, true);
		
		for(int i = 2; i < primeNum.length; i++) {
			if(!primeNum[i])
				continue;
			for(int j = i * i; j < primeNum.length; j += i)
				primeNum[j] = false;
		}
	}
}