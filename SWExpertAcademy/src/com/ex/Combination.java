package com.ex;


import java.util.Arrays;

public class Combination {
	public static void main(String[] args) {
		comb(new int[] {1, 2, 3}, new int[2], 0, 0);
	}
	
	static void comb(int[] arr, int[] sel, int idx, int cnt) {
		if(cnt == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx == arr.length)
			return;
		
		sel[cnt] = arr[idx];
		comb(arr, sel, idx + 1, cnt + 1);
		sel[cnt] = 0;
		comb(arr, sel, idx + 1, cnt);
	}
}