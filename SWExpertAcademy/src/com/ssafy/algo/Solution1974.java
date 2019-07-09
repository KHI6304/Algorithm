package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int[][] arr = new int[9][9];
			
			int[] num = null;
			boolean flag = true;
			for(int i = 0; i < arr.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				num = new int[10];
				for(int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					num[ arr[i][j] ]++;
					if(num[ arr[i][j] ] == 2)
						flag = false;
				}
			}
			
			if(!flag) {
				bw.write("#" + testCase + " 0\n");
				continue;
			}
			
			for(int i = 0; i < arr.length && flag; i++) {
				num = new int[10];
				for(int j = 0; j < arr[i].length && flag; j++) {
					num[ arr[j][i] ]++;
					if(num[ arr[j][i] ] == 2)
						flag = false;
				}
			}
			
			if(!flag) {
				bw.write("#" + testCase + " 0\n");
				continue;
			}
			
			for(int a = 0; a < 3 && flag; a++) {
				for(int b = 0; b < 3 && flag; b++) {
					num = new int[10];
					for(int c = 0; c < 3 && flag; c++) {
						for(int d = 0; d < 3 && flag; d++) {
							num[ arr[c + (a * 3)][d + (b * 3)] ]++;
							if(num[ arr[c + (a * 3)][d + (b * 3)] ] == 2)
								flag = false;
						}
					}
				}
			}
			
			if(!flag)
				bw.write("#" + testCase + " 0\n");
			else
				bw.write("#" + testCase + " 1\n");
		}
		bw.close();	
	}
}