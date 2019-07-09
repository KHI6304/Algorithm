package algo.BaekJoon;

import java.util.Scanner;

public class Main01110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 1;
		int tmp = (N % 10) * 10 + (N / 10 + N % 10) % 10;
		while(tmp != N) {
			tmp = (tmp % 10) * 10 + (tmp / 10 + tmp % 10) % 10;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}