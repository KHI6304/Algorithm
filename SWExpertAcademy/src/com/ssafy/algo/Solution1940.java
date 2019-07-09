package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int sol = 0;
			int velocity = 0;
			int accel = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int inp = Integer.parseInt(st.nextToken());
				if(inp != 0) 
					accel = Integer.parseInt(st.nextToken());
				else
					accel = 0;
				
				if(inp == 1)
					velocity += accel;
				else if(inp == 2) {
					if(velocity < accel)
						velocity = 0;
					else
						velocity -= accel;
				}
				
				sol += velocity;
			}
			
			System.out.println("#" + tc + " " + sol);
		}
	}
}