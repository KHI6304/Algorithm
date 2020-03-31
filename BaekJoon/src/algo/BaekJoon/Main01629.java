package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(A % C, B));
	}
	
	private static long A, B, C;
	
	private static long pow(long num, long n) {
		if(n == 0) return 1;
		
		long tmp = pow(num, n / 2) % C;
		if(n % 2 == 0) return tmp * tmp % C;
		else return (tmp * tmp % C) * num % C;
	}
}