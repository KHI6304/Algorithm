package com.ex;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {5, 1, 9, 6, 7, 8};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int[] arr, int start, int end) {
		if(start >= end)
			return;
		int pivot = partition(arr, start, end);
		quickSort(arr, start, pivot - 1);
		quickSort(arr, pivot + 1, end);
	}
	
	static int partition(int[] arr, int p, int r) {
		int x = arr[r];
		int i = p;
		for(int j = p; j < r; j++) {
			if(arr[j] <= x) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, r);
		return i;
	}

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}