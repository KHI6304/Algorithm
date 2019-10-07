package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main06588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		primes = new boolean[1000001];
		primes[0] = primes[1] = primes[2] = true;
		Eratostenes();
		
		while(n != 0) {
			int a = -1, b = -1;
			
			for(int i = 0; i < n; i++) {
				if(primes[i])
					continue;
				
				int tmp = n - i;
				if(i == tmp)
					continue;
				
				if(!primes[tmp]) {
					if(a != -1)
						if( b - a > Math.abs(tmp - i) )
							continue;
					
					a = i < tmp ? i : tmp;
					b = i < tmp ? tmp : i;
				}
			}
			
			if(a == -1)
				System.out.println("Goldbach's conjecture is wrong.");
			else
				System.out.println(n + " = " + a + " + " + b);
			
			n = Integer.parseInt(br.readLine());
		}
	}
	
	private static boolean[] primes;
	
	private static void Eratostenes() {
		for(int i = 2; i * i <= 1000000; i++)
			for(int j = i * i; j <= 1000000; j += i)
				primes[j] = true;
	}
}