package com.ssafy.algo;

import java.util.Scanner;

public class Solution6808 {
	static int ind = -1;
	static int xScore, yScore;
	static int xWin = 0, yWin = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int[] arr = new int[9];
			int[] sol = new int[9];
			
			for(int i = 0; i < arr.length; i++)
				arr[i] = sc.nextInt();
			
			int index = -1;
			for(int i = 1; i <= 18; i++) {
				boolean flag = true;
				for(int j = 0; j < arr.length; j++)
					if(arr[j] == i)
						flag = false;
				if(flag)
					sol[++index] = i;
			}
			
			
			xWin = 0;
			yWin = 0;
			
			Perm(sol, arr, 0, 9, 9);
			
			
			System.out.printf("#%d %d %d%n", testCase, xWin, yWin);
			ind = -1;
		}
	}
	
	public static void Perm(int[] arr, int[] arr2, int depth, int n, int k) {
		if(depth == k) {
			ind++;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] < arr2[i])
					xScore += arr[i] + arr2[i];
				else
					yScore += arr[i] + arr2[i];
			}
			if(xScore > yScore)
				xWin++;
			else
				yWin++;
			xScore = 0;
			yScore = 0;
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			Perm(arr, arr2, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}