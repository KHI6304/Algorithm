package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1209 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			
			int[][] map = new int[100][100];
			int max = 0;
			int sum = 0;
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				sum = 0;
				for(int j = 0; j < 100; j++)
					sum += map[i][j] = Integer.parseInt(st.nextToken());
				if(sum > max)
					max = sum;
			}
			
			for(int col = 0; col < 100; col++) {
				sum = 0;
				for(int row = 0; row < 100; row++)
					sum += map[row][col];
				if(sum > max)
					max = sum;
			}
			
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0; i < 100; i++) {
				sum1 += map[i][i];
				sum2 += map[i][99 - i];
			}
			if(sum1 > max)
				max = sum1;
			if(sum2 > max)
				max = sum2;
			
			System.out.println("#" + tc + " " + max);
		}
	}
}