package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1493 {
	static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[10000];
		arr[1] = 1;
		for(int i = 1; arr[i] + i <= 100000; i++)
			arr[i + 1] = arr[i] + i;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			Position[] ps = new Position[3];
			for(int i = 1; i < arr.length && arr[i] != 0; i++) {
				if(p == arr[i])
					ps[0] = new Position(1, i);
				if(q == arr[i])
					ps[1] = new Position(1, i);
				
				if(ps[0] == null && p < arr[i])
					ps[0] = new Position(1 + (p - arr[i - 1]), (i - 1) - (p - arr[i - 1]));
				
				if(ps[1] == null && q < arr[i])
					ps[1] = new Position(1 + (q - arr[i - 1]), (i - 1) - (q - arr[i - 1]));
				
				if(ps[0] != null && ps[1] != null)
					break;
			}
			
 			ps[2] = new Position(ps[0].x + ps[1].x, ps[0].y + ps[1].y);
			int tmpY = ps[2].y + ps[2].x - 1;
			int sol = arr[tmpY] + (tmpY - ps[2].y);
			sb.append("#" + tc + " " + 	sol + "\n");
		}
		System.out.print(sb);
	}
}