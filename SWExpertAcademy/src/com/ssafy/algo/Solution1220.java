package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			
			int[][] map = new int[100][100];
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			for(int i = 0; i < 100; i++) {
				boolean rflag = false;
				for(int j = 0; j < 100; j++) {
					if(map[j][i] == 1)
						rflag = true;
					
					if(rflag && map[j][i] == 2) {
						rflag = false;
						cnt++;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}