package com.ex;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1244_대경 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String input = sc.next();
			int N = sc.nextInt();
			
			int[] num = new int[input.length()];
			for(int i = 0; i < input.length(); i++)
				num[i] = input.charAt(i) - '0';
			
			ans = 0;
			solve(num, 0, 0, N);
			System.out.println(ans);
		}
	}
	
	static int ans = 0;
	static void solve(int[] num, int start, int cnt, int N) {
		if(cnt == N) {
			// 교환횟수 모두 소진
			int sum = 0;
			for(int i = 0; i < num.length; i++)
				//sum += (num[i] * Math.pow(10, num.length - 1));
				sum = sum * 10 + num[i];
			if(sum > ans)
				ans = sum;
			
			return;
		}
		
		if(start == num.length - 2) {
			// 배열 마지막에서 두번째 도착
			if(cnt % 2 == 0)
				solve(num, start, N, N);
			else {
				swap(num, start, start + 1);
				solve(num, start, N, N);
			}
			return;
		}
		// start 다음 칸부터 끝까지 중에서 가장 큰 숫자의 위치를 찾아서, 그놈과 start와 swap
		
		// 가장 큰수를 찾자
		int big = -1;
		int bigIdx = -1;
		for(int i = start + 1; i < num.length; i++) {
			if(big < num[i]) {
				bigIdx = i;
				big = num[i];
			}
		}
		if(bigIdx != start) {
			for(int i = start + 1; i < num.length; i++) {
				if(big == num[i]) {
					swap(num, i, start);
					solve(num, start + 1, cnt + 1, N);
					swap(num, i, start);
				}
			}
		}
		else
			solve(num, start, cnt, N);
	}
	
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}