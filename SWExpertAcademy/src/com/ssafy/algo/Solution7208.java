package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7208 {
	static int N;
	static int[] colors;
	static int[] colorsTmp;
	static int[][] map;
	static int sol;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			colors = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				colors[i] = Integer.parseInt(st.nextToken());
			colorsTmp = Arrays.copyOf(colors, N);
			
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			sol = Integer.MAX_VALUE;
			recur(0);
			sb.append("#").append(tc).append(" ").append(sol).append("\n");
		}
		System.out.println(sb);
	}
	
	// 4가지 색상으로 칠할 수 있는 모든 경우 뽑기
	static void recur(int idx) {
		if(idx >= N) {
			if(isOk()) {
				// 기존의 상태에서 가장 변경횟수가 적은 값을 추출
				int tmp = 0;
				for(int i = 0; i < N; i++) {
					if(colors[i] != colorsTmp[i])
						tmp++;
				}
				if(tmp < sol)
					sol = tmp;
			}
			return;
		}
		
		for(int i = 1; i <= 4; i++) {
			colorsTmp[idx] = i;
			recur(idx + 1);
		}
	}
	
	// 인접된 국가끼리 같은색이면 거르기
	static boolean isOk() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if( map[i][j] == 1 && colorsTmp[i] == colorsTmp[j] )
					return false;
			}
		}
		return true;
	}
}