package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1970 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			bw.write("#" + testCase + "\n");
			for(int i = 0; i < arr.length; i++) {
				if( (N / arr[i]) >= 1 ) {
					bw.write( (N / arr[i]) + " " );
					N %= arr[i];
					continue;
				}
				bw.write("0 ");
			}
			bw.write("\n");
		}
		bw.close();
	}
}