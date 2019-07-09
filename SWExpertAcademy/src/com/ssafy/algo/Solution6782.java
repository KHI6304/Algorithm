package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6782 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long[] list = new long[1000000];
		for(int i = 1; i <= list.length; i++)
			list[i - 1] = i * (long)i;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int TestCase = 1; TestCase <= T; TestCase++) {
			long N = Long.parseLong(br.readLine());
			int cnt = 0;
			
			while(N != 2) {
				if(Math.sqrt(N) == (long)Math.sqrt(N)) {
					N = (long)Math.sqrt(N);
					cnt++;
				}
				else {
					int sol = binarySearch(list, N, list.length);
					cnt += list[sol] - N;
					N = list[sol];
				}
			}
			
			bw.write("#" + TestCase + " " + cnt + "\n");
		}
		bw.close();
	}
	
	// 배열에 있지 않은 값을 찾기 위한 이진 검색 구현
	static int binarySearch(long[] li, long key, int ind) {
		int start = 0;
		int end = ind;
		int sol = -1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			if(li[mid] > key)
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		sol = start;
		return sol;
	}
}