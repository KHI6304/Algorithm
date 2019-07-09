package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution3752 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			set = new HashSet<>();
			powerSet(arr, new boolean[N], 0);
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}
		System.out.print(sb);
	}
	
	static Set<Integer> set;
	static void powerSet(int[] arr, boolean[] sel, int idx) {
		if(arr.length == idx) {
			int sum = 0;
			for(int i = 0; i < arr.length; i++)
				if(sel[i])
					sum += arr[i];
			set.add(sum);
			return;
		}
		
		sel[idx] = true;
		powerSet(arr, sel, idx + 1);
		sel[idx] = false;
		powerSet(arr, sel, idx + 1);
	}
}