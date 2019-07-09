package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3234 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] fact = new int[10];
		fact[1] = 1;
		for(int i = 2; i <= 9; i++)
			fact[i] = fact[i - 1] * i;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			sol = 0;
			perm(arr, 0);
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int sol;
	static void solve(int[] arr, int leftSum, int rightSum, int idx) {
		if(leftSum < rightSum)
			return;
		
		if(arr.length == idx) {
			sol++;
			return;
		}
		
		solve(arr, leftSum + arr[idx], rightSum, idx + 1);
		solve(arr, leftSum, rightSum + arr[idx], idx + 1);
	}
	
	static void perm(int[] arr, int idx) {
		if(arr.length == idx) {
			solve(arr, 0, 0, 0);
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			swap(arr, i, idx);
			perm(arr, idx + 1);
			swap(arr, i, idx);
		}
	}
	
	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}