package algo.BaekJoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Main02407 {
	private static BigInteger[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new BigInteger[N + 1][M + 1];
		
		System.out.println(String.valueOf(comb(N, M)));
	}
	
	public static BigInteger comb(int n, int r) {
		if(n == r || r == 0) return BigInteger.ONE;
		if(arr[n][r] != null) return arr[n][r];
		arr[n][r] = new BigInteger("0");
		return arr[n][r] = arr[n][r].add(comb(n - 1, r - 1).add(comb(n - 1, r)));
	}
}