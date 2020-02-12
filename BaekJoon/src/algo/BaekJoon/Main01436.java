package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10000];
		
		int idx = 0;
		int num = 666;
		while(idx != 10000) {
			int tmp = num;
			
			boolean flag = false;
			int cnt = 0;
			while(tmp != 0) {
				int n = tmp % 10;
				
				if(n == 6) cnt++;
				else cnt = 0;
				
				if(cnt == 3) {
					flag = true;
					break;
				}
				
				tmp /= 10;
			}
			
			if(flag)
				arr[idx++] = num;
			
			num++;
		}
		
		System.out.println(arr[N - 1]);
	}
}