package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main04948 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		primeNum();
		
		int num = Integer.parseInt(br.readLine());
		while(num != 0) {
			int cnt = 0;
			for(int i = num + 1; i <= num * 2; i++)
				if(prime[i])
					cnt++;
			bw.write(cnt + "\n");
			num = Integer.parseInt(br.readLine());
		}
		bw.close();
	}
	
	static boolean[] prime = new boolean[123456 * 2 + 1];
	static void primeNum() {
		
		for(int i = 2; i <= 123456 * 2; i++) {
			int sqrtNum = (int)Math.sqrt(i);
			boolean flag = true;
			for(int j = 2; j <= sqrtNum; j++)
				if(i % j == 0)
					flag = false;
			if(flag)
				prime[i] = true;
		}
	}
}