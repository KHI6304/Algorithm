package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main05585 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int money = 1000 - Integer.parseInt(br.readLine());
		int[] coins = {500, 100, 50, 10, 5, 1};
		
		int sol = 0;
		for(int i = 0; i < coins.length; i++) {
			if(money == 0) break;
			if(money < coins[i]) continue;
			
			sol += money / coins[i];
			money %= coins[i];
		}
		
		System.out.println(sol);
	}
}