package com.ex;

import java.util.Scanner;

public class Solution1244_2 {
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			int N = sc.nextInt();
			int[] num = new int[s.length()];
			for(int i = 0; i < s.length(); i++)
				num[i] = s.charAt(i) - '0';
			
			max = 0;
			solve(num, 0, N);
			System.out.println("#" + tc + " " + max);
		}
	}
	
	static void solve(int[] num, int cnt, int N) {
		if(cnt == 6 || cnt == N) {
			int sum = 0;
			for(int i = 0; i < num.length; i++)
				//sum += (num[i] * Math.pow(10, num.length - 1));
				sum = sum * 10 + num[i];
			if(max < sum)
				max = sum;
			return;
		}
		
		for(int i = 0; i < num.length; i++) {
			for(int j = i + 1; j < num.length; j++) {
				swap(num, i, j);
				solve(num, cnt + 1, N);
				swap(num, i, j);
			}
		}
	}
	
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}