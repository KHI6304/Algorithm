package com.ssafy.algo;

import java.util.Scanner;

public class Solution1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int TC = 1; TC <= T; TC++) {
			sc.nextInt();
			int[] arr = new int[1000];
			int[] cnt = new int[101];
 			
			for(int i = 0; i < arr.length; i++)
				arr[i] = sc.nextInt();
			
			for(int i = 0; i < arr.length; i++)
				cnt[arr[i]]++;
			
			int max = 0;
			int index = 0;
			for(int i = cnt.length - 1; i >= 0; i--) {
				if(cnt[i] > max) {
					max = cnt[i];
					index = i;
				}
			}
			
			System.out.printf("#%d %d%n", TC, index);
		}
	}
}