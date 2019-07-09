package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		arr = BubbleSort(arr);
		
		System.out.println(arr[N / 2]);
	}
	
	public static int[] BubbleSort(int[] arr) {
		for(int i = arr.length - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}
}