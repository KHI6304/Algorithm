package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1959 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				A[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++)
				B[i] = Integer.parseInt(st.nextToken());
			
			int max = 0;
			if(N < M) {
				for(int i = 0; i <= M - N; i++) {
					int tmp = 0;
					for(int j = 0; j < N; j++)
						tmp += A[j] * B[j + i];
					
					if(tmp > max)
						max = tmp;
				}
			}
			else if(N > M) {
				for(int i = 0; i <= N - M; i++) {
					int tmp = 0;
					for(int j = 0; j < M; j++)
						tmp += A[j + i] * B[j];
					
					if(tmp > max)
						max = tmp;
				}
			}
			
			System.out.println("#" + testCase + " " + max);
		}
	}
}