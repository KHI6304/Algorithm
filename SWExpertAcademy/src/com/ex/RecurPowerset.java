package com.ex;

public class RecurPowerset {
	public static void main(String[] args) {
		powerset(new int[] {1, 2, 3}, new boolean[3], 0, 0);
	}
	
	static void powerset(int[] arr, boolean[] sel, int idx, int cnt) {
		if(idx == arr.length) {
			if (cnt == 2) {
				for (int i = 0; i < arr.length; i++)
					if (sel[i])
						System.out.print(arr[i] + " ");
				System.out.println();
				return;
			}
			return;
		}
		
		sel[idx] = false;
		powerset(arr, sel, idx + 1, cnt);
		sel[idx] = true;
		powerset(arr, sel, idx + 1, cnt + 1);
	}
}