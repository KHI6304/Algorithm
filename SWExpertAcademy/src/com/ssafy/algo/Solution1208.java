package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			int cnt = Integer.parseInt(br.readLine());
			int[] map = new int[100];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < map.length; i++)
				map[i] = Integer.parseInt(st.nextToken());
			
			int sol = 0;
			while(cnt != 0) {
				Arrays.sort(map);
				map[0] += 1;
				map[99] -= 1;
				Arrays.sort(map);
				sol = map[99] - map[0];
				cnt--;
			}
			System.out.println("#" + tc + " " + sol);
		}
	}
}