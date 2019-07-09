package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[100][100];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			
		}
	}
}