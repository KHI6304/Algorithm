package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i = 1; i <= 5000000; i++) {
			if(sum + i < N) {
				sum += i;
				continue;
			}
			
			int start = sum + 1;
			if(i % 2 == 0) {
				int x = 1;
				int y = i;
				while(start != N) {
					x += 1;
					y -= 1;
					start++;
				}
				System.out.println(x + "/" + y);
				break;
			}
			else {
				int x = i;
				int y = 1;
				while(start != N) {
					x -= 1;
					y += 1;
					start++;
				}
				System.out.println(x + "/" + y);
				break;
			}
		}
	}
}