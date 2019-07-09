package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main02748 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		System.out.println(fibo(N));
	}
	
	static long[] memo = new long[91];
	static {
		memo[0] = 0;
		memo[1] = 1;
	}
	
	static long fibo(int n) {
		if(n >= 2 && memo[n] == 0)
			memo[n] = fibo(n - 1) + fibo(n - 2);
		
		return memo[n];
	}
}
