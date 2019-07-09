package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution2005 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] arr = new int[10][];
		for(int i = 0; i < arr.length; i++)
			arr[i] = new int[i + 1];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j <= i; j++) {
				arr[i][j] = 1;
				
				if(i > 1 && j > 0 && j < i)
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			
			bw.write("#" + testCase + "\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < arr[i].length; j++)
					bw.write(arr[i][j] + " ");
				bw.write("\n");
			}
		}
		bw.close();
	}
}