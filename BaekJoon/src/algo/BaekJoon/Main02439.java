package algo.BaekJoon;

import java.util.Scanner;

public class Main02439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = N - i - 1; j > 0; j--)
				System.out.print(" ");
			for(int j = 0; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}