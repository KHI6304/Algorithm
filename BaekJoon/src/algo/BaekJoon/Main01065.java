package algo.BaekJoon;

import java.util.Scanner;

public class Main01065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		if(N < 100) {
			System.out.println(N);
			return;
		}
		
		int sol = 99;
		for(int i = 100; i <= N; i++)
			if(check(i))
				sol++;
		
		System.out.println(sol);
	}
	
	static boolean check(int n) {
		boolean flag = true;
		String tmp = String.valueOf(n);
		int len = tmp.length();
		int[] arr = new int[len];
		int[] sub = new int[len - 1];
		
		for(int i = 0; i < len; i++) {
			arr[i] = n % 10;
			n /= 10;
		}
		
		for(int i = 0; i < len - 1; i++) {
			sub[i] = arr[i + 1] - arr[i];
			if(i != 0 && sub[i] != sub[i - 1])
				flag = false;
		}
		
		return flag;
	}
}