package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1285 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			
			for(int i = 0; i < arr.length; i++)
				arr[i] = Math.abs( Integer.parseInt( st.nextToken() ) );
			Arrays.sort(arr);
			
			int cnt = 1;
			int min = arr[0];
			for(int i = 1; i < arr.length; i++)
				if(arr[i] == min)
					cnt++;
				else
					break;
			
			bw.write("#" + testCase + " " + min + " " + cnt + "\n");
		}
		bw.close();
	}
}