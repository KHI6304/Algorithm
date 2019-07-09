package com.ex;


public class Recur {
	public static void main(String[] args) {
		recur4(new int[] {1, 0, 0, 2, 0, 0, 0, 3, 4, 2, 0}, 0, 0);
		System.out.println(ans);
	}
	
	static void recur(int[] arr, int idx) {
		// 기본 부분
		if(idx == arr.length)
			return;
		
		
		// 유도된 부분
		recur(arr, idx + 1);
	}
	
	static void recur2(int[] arr, int idx, int cnt) {
		if(idx >= arr.length) {
			System.out.println(cnt);
			return;
		}
		
		recur2(arr, idx + arr[idx] + 1, cnt + 1);
	}
	
	static void recur3(int[] arr, int idx, int cnt) {
		if(idx >= arr.length) {
			System.out.println(cnt);
			return;
		}
		
		if(arr[idx] % 2 == 0)
			recur3(arr, idx + 2, cnt + 1);
		else
			recur3(arr, idx + 1, cnt + 1);
	}
	
	static int ans = 987654321;
	static void recur4(int[] arr, int idx, int cnt) {
		if(idx >= arr.length) {
			if(ans > cnt)
				ans = cnt;
			return;
		}
		
		if(arr[idx] <= 1)
			recur4(arr, idx + 1, cnt + 1);
		else
			for(int i = 1; i < arr[idx] + 1; i++)
				recur4(arr, idx + i, cnt + 1);
	}
}