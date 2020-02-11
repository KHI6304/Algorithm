package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main09020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] primeNumber = new boolean[10000];
		for(int i = 2; i < 10000; i++)
			primeNumber[i] = true;
		
		for(int i = 2; i * i < 10000; i++)
			for(int j = i * i; j < 10000; j += i)
				primeNumber[j] = false;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int low = n / 2;
			int high = n / 2;
			
			while( !(primeNumber[low] && primeNumber[high]) ) {
				low--;
				high++;
			}
			
			System.out.println(low + " " + high);
		}
	}
}