package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main02292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		for(int num = 1; num <= 1100000000; num += 6 * (cnt - 1)) {
			if(N <= num) {
				System.out.println(cnt);
				break;
			}
			cnt++;
		}
	}
}