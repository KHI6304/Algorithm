package com.ex;

import java.util.Scanner;

public class NQueen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		
		backtrack(map, 0, N);
		System.out.println(ans);
	}
	
	// line은 행을 의미한다
	static int ans = 0;
	static void backtrack(int[][] map, int line, int N) {
		if(line == N) {
			ans++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			boolean canBeNQueen = true;
			
			int left = i;
			int right = i;
			for(int j = line - 1; j >= 0; j--) {
				left--;
				right++;
				if( map[j][i] == 1 ) {
					canBeNQueen = false;
					break;
				}
				if(left >= 0 && left < N && map[j][left] == 1) {
					canBeNQueen = false;
					break;
				}
				if(right >= 0 && right < N && map[j][right] == 1) {
					canBeNQueen = false;
					break;
				}
			}
			
			if(canBeNQueen) {
				map[line][i] = 1;
				backtrack(map, line + 1, N);
				map[line][i] = 0;
			}
		}
	}
}