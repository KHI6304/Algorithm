package com.ex;


import java.util.Arrays;

public class CardTest {
	public static void main(String[] args) {
		int[] cards = {1, 2, 3, 4, 5};
		
		cardShuffle(cards, 0, 2);
	}
	
	static void cardShuffle(int[] cards, int cnt, int N) {
		if(cnt == N) {
			System.out.println(Arrays.toString(cards));
			return;
		}
		
		for(int i = 0; i < cards.length; i++) {
			for(int j = i + 1; j < cards.length; j++) {
				swap(cards, i, j);
				cardShuffle(cards, cnt + 1, N);
				swap(cards, i, j);
			}
		}
	}
	
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}