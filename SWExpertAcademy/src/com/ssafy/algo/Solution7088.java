package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7088 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N + 1][4];
			int[] val = new int[4];
			for(int i = 1; i <= N; i++) {
				int grade = Integer.parseInt(br.readLine());
				map[i][grade]++;
				val[grade]++;
				map[i] = Arrays.copyOf(val, 4);
			}
			
			sb.append("#").append(tc).append("\n");
			for(int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken()) - 1;
				int last = Integer.parseInt(st.nextToken());
				
				int n1 = map[last][1] - map[start][1];
				int n2 = map[last][2] - map[start][2];
				int n3 = map[last][3] - map[start][3];
				sb.append(n1).append(" ").append(n2).append(" ").append(n3).append("\n");
 			}
		}
		System.out.print(sb);
	}
}