package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3074 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				if(arr[i] > max)
					max = arr[i];
			}
			
			long left = 0;
			long right = (long)max * M;
			
			while(left <= right) {
				long mid = (left + right) / 2;
				
				long sum = 0;
				for(int i = 0; i< N; i++)
					sum += mid / arr[i];
				
				if(sum >= M)
					right = mid - 1;
				else
					left = mid + 1;
			}
			System.out.println("#" + tc + " " + left);
		}
	}
}