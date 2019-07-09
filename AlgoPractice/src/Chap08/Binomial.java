package Chap08;

import java.util.Arrays;

public class Binomial {
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++)
			Arrays.fill(memo[i], -1);
		
		System.out.println(bino(80, 20));
//		System.out.println(bino2(80, 20));
	}
	
	static int bino(int n, int r) {
		if( r == 0 || n == r ) return 1;
		return bino(n - 1, r - 1) + bino(n - 1, r);
	}
	
	static long[][] memo = new long[100][100];
	
	static long bino2(int n, int r) {
		if( r == 0 || n == r ) return 1;
		if( memo[n][r] != -1 ) return memo[n][r];
		
		return memo[n][r] = bino2(n - 1, r - 1) + bino2(n - 1, r);
	}
}