package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] map = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				map[i] = Integer.parseInt(st.nextToken());
			
			int sol = 0;
			for(int i = 2; i < (N - 2); i++) {
				int max = 0;
				for(int j = i - 2; j <= i + 2; j++) {
					if( j == i)
						continue;
					if(map[j] > max)
						max = map[j];
				}
				if(map[i] > max)
					sol += map[i] - max;
			}
			
			System.out.println("#" + tc + " " + sol);
		}
	}
}