package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6853 {
	static class Rectangle {
		int x1;
		int y1;
		int x2;
		int y2;
		
		public Rectangle(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			Rectangle r = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			int N = Integer.parseInt(br.readLine());
			
			int cnt1 = 0;	// 내부
			int cnt2 = 0;	// 위
			int cnt3 = 0;	// 외부
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(x > r.x1 && x < r.x2 && y > r.y1 && y < r.y2)
					cnt1++;
				else if( ( (x == r.x1 || x == r.x2) && y >= r.y1 && y <= r.y2) || ( (y == r.y1 || y == r.y2) && x >= r.x1 && x <= r.x2) )
					cnt2++;
				else
					cnt3++;
			}
			
			System.out.println("#" + tc + " " + cnt1 + " " + cnt2 + " " + cnt3);
		}
	}
}