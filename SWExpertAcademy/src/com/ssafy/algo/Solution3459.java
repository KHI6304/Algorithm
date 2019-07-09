package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3459 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			
			long num = 1;
			long cnt = 2;
			if(N == 1)
				System.out.println("#" + tc + " Bob");
			while(N != 1 && true) {
				long n = (long) Math.pow(2, cnt);
				if(N <= num + n) {
					System.out.println("#" + tc + " Alice");
					break;
				}
				else
					num += n;
				
				if(N <= num + n) {
					System.out.println("#" + tc + " Bob");
					break;
				}
				else
					num += n;
				cnt += 2;
				
			}
		}
	}
}