package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution5658 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			char[] arr = br.readLine().toCharArray();
			
			List<Integer> list = new LinkedList<>();
			for(int i = 0; i < N / 4; i++) {
				for(int j = i; j < arr.length; j += N / 4) {
					int sum = 0;
					
					for(int k = 0; k < N / 4; k++)
						sum += convert(arr[ (j + k) % arr.length ]) * Math.pow(16, N / 4 - k - 1) ;
					
					if(!list.contains(sum))
						list.add(sum);
				}
			}
			
			Collections.sort(list);
			Collections.reverse(list);
			
			System.out.println("#" + tc + " " + list.get(K - 1));
		}
	}
	
	static int convert(char c) {
		if(!Character.isDigit(c))
			return c - 55;
		else
			return c - '0';
	}
}