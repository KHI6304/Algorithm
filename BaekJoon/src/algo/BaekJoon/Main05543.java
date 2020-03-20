package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main05543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int hamburger = Integer.MAX_VALUE;
		int drink = Integer.MAX_VALUE;
		
		for(int i = 0; i < 3; i++) {
			int tmp = Integer.parseInt(br.readLine());
			hamburger = Math.min(hamburger, tmp);
		}
		
		for(int i = 0; i < 2; i++) {
			int tmp = Integer.parseInt(br.readLine());
			drink = Math.min(drink, tmp);
		}
		
		System.out.println(hamburger + drink - 50);
	}
}