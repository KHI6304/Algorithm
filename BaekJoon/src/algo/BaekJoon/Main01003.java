package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		System.out.println(fibo(N));
	}
	
	static int[] memo = new int[50];
	static {
		memo[0] = 0;
		memo[1] = 1;
	}
	
	static int fibo(int n) {
		if(n >= 2 && memo[n] == 0)
			memo[n] = fibo(n - 1) + fibo(n - 2);
		
		return memo[n];
	}
}