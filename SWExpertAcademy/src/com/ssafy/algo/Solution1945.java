package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1945 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = {2, 3, 5, 7, 11};
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			bw.write("#" + testCase + " ");
			for(int i = 0; i < arr.length; i++) {
				int cnt = 0;
				while( (N % arr[i]) == 0 ) {
					N /= arr[i];
					cnt++;
				}
				bw.write(cnt + " ");
			}
			bw.write("\n");
		}
		bw.close();
	}
}