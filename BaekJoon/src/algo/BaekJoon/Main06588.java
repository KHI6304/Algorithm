package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main06588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] primes = new boolean[1000000];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		
		for(int i = 2; i * i < primes.length; i += 1)
			for(int j = i * i; j < primes.length; j += i)
				primes[j] = false;
		
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			int a = 3, b = n - 3;
			while(a <= b) {
				if(a > b) {
					System.out.println("Goldbach's conjecture is wrong.");
					break;
				}
				
				int sum = a + b;
				
				if(sum == n && primes[a] && primes[b]) {
					System.out.println(n + " = " + a + " + " + b);
					break;
				}
				else {
					if(sum < n)
						a += 2;
					else
						b -= 2;
				}
			}
		}
	}
}