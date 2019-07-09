package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[8][8];
			for(int i = 0; i < 8; i++)
				map[i] = br.readLine().toCharArray();
			
			int sol = 0;
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j <= 8 - N; j++) {
					boolean flag = true;
					for(int k = 0; k < (N / 2) && flag; k++)
						if(map[i][j + k] != map[i][j + N - k - 1])
							flag = false;
					if(flag)
						sol++;
					
					flag = true;
					for(int k = 0; k < (N / 2) && flag; k++)
						if(map[j + k][i] != map[j + N - k - 1][i])
							flag = false;
					if(flag)
						sol++;
				}
			}
			
			System.out.println("#" + tc + " " + sol);
		}
	}
}