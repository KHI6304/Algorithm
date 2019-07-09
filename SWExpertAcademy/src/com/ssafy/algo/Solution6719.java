package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			
			double sol = 0;
			for(int i = arr.length - K; i < arr.length; i++)
				sol = (sol + arr[i]) / 2;
			
			System.out.println("#" + testCase + " " + sol);
		}
	}
}