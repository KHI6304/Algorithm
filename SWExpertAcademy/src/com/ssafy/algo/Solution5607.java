package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5607 {
	final static int mod = 1234567891;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		long[] arr = new long[1000001];
		
		arr[0] = 1;
		for(int i = 1; i < arr.length; i++)
			arr[i] = arr[i - 1] * i % mod;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long sol = ( arr[N] * ( pow(arr[N - R] * arr[R] % mod, mod - 2)) ) % mod;
			
			System.out.println("#" + testCase + " " + sol);
		}
	}
	
	public static long pow(long num, int cnt) {
		if(cnt == 0) return 1;
		if(cnt == 1) return num;
		
		long res = pow(num, cnt / 2) % mod;
		
		if(cnt % 2 == 1)
			return res * res % mod * pow(num, 1) % mod;
		else
			return res * res % mod;
	}
}