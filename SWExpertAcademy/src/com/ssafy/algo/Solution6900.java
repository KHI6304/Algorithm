package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6900 {
	static class Lotto {
		String num;
		int price;
		
		public Lotto(String num, int price) {
			this.num = num;
			this.price = price;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Lotto[] ls = new Lotto[N];
			String[] nums = new String[M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ls[i] = new Lotto(st.nextToken(), Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 0; i < M; i++)
				nums[i] = br.readLine();
			
			long sol = 0;
			for(int i = 0; i < nums.length; i++) {
				for(int j = 0; j < ls.length; j++) {
					boolean flag = true;
					String s = ls[j].num;
					for(int k = 0; k < s.length() && flag; k++) {
						if(s.charAt(k) != '*') {
							if(nums[i].charAt(k) != s.charAt(k))
								flag = false;
						}
					}
					if(flag) {
						sol += ls[j].price;
					}
				}
			}
			
			System.out.println("#" + tc + " " + sol);
		}
	}
}