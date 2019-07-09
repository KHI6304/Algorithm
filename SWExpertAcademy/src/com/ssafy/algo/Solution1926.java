package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1926 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			int cnt = 0;
			int tmp = i;
			while(tmp > 0) {
				int num = tmp % 10;
				if(num != 0 && num % 3 == 0)
					cnt++;
				tmp /= 10;
			}
			
			if(cnt > 0) {
				while(cnt > 0) {
					bw.write("-");
					cnt--;
				}
				bw.write(" ");
			}
			else {
				bw.write(i + " ");
			}
		}
		bw.close();
	}
}