package com.ex;


import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {
		perm(new int[] {1, 2, 3, 4}, 0);
	}
	
	static void perm(int[] arr, int idx) {
		if(idx == arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			swap(arr, idx, i);
			perm(arr, idx + 1);
			swap(arr, idx, i);
		}
	}
	
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}