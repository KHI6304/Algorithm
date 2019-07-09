package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Solution1288 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[] flag = new boolean[10];
			boolean exit = true;
			int cnt = 0;
			int x = N;
			while(exit) {
				int tmp = x;
				while(tmp > 0) {
					int num = tmp % 10;
					flag[num] = true;
					tmp /= 10;
				}
				
				for(boolean b : flag)
					if(b == true) cnt++;
				
				if(cnt == 10) 
					exit = false;
				else
					x += N;
				cnt = 0;
			}
			
			System.out.println("#" + testCase + " " + x);
		}
	}
}