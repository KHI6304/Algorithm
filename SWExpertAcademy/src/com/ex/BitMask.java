package com.ex;

public class BitMask {
	public static void main(String[] args) {
		String[] items = {"Apple", "Potato", "Coffee", "Juice"};
		
		for(int i = 0; i < (1 << items.length); i++) {
			for(int j = 0; j < items.length; j++)
				if( (i & (1 << j)) != 0)
					System.out.print(items[j] + " ");
			System.out.println();
		}
	}
}