package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1984 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int testCase = 1; testCase <= T; testCase++) {
			int[] arr = new int[10];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int max = 0, min = 10000;
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
				if(arr[i] > max) max = arr[i];
				if(arr[i] < min) min = arr[i];
			}
			
			int sum = 0;
			for(int i = 0; i < arr.length; i++)
				if(arr[i] != max && arr[i] != min) sum += arr[i];
			bw.write("#" + testCase + " " + Math.round(sum / 8.0) + "\n");
		}
		bw.close();
	}
}