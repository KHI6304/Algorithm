package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1983 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			double[] arr = new double[N];
			double[] sortedArr = new double[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int mid = Integer.parseInt(st.nextToken());
				int last = Integer.parseInt(st.nextToken());
				int hw = Integer.parseInt(st.nextToken());
				double sum = mid * 0.35 + last * 0.45 + hw * 0.2;
				
				arr[i] = sum;
				sortedArr[i] = sum;
			}
			
			Arrays.sort(sortedArr);
			int rank = 1;
			double search = arr[K - 1];
			for(int i = arr.length - 1; i >= 0; i--) {
				if(search == sortedArr[i]) break;
				rank++;
			}
			
			bw.write("#" + testCase + " ");
			double n = (double)rank / N;
			if(n <= 0.1)
				bw.write("A+\n");
			else if(n <= 0.2)
				bw.write("A0\n");
			else if(n <= 0.3)
				bw.write("A-\n");
			else if(n <= 0.4)
				bw.write("B+\n");
			else if(n <= 0.5)
				bw.write("B0\n");
			else if(n <= 0.6)
				bw.write("B-\n");
			else if(n <= 0.7)
				bw.write("C+\n");
			else if(n <= 0.8)
				bw.write("C0\n");
			else if(n <= 0.9)
				bw.write("C-\n");
			else
				bw.write("D0\n");
		}
		bw.close();
	}
}