package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2383 {
	static class Person {
		int x;
		int y;
		
		public Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Stair {
		int x;
		int y;
		int t;		// 계단을 내려가는데 걸리는 시간
		public Stair(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			ps = new Person[10];
			int psize = 0;
			ss = new Stair[2];
			int ssize = 0;
			
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)
						ps[psize++] = new Person(i, j);
					else if(map[i][j] != 0 && map[i][j] != 1)
						ss[ssize++] = new Stair(i, j, map[i][j]);
				}
			}
			
			sol = Integer.MAX_VALUE;
			
			powerSet(new boolean[psize], 0);
			
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static Person[] ps;
	static Stair[] ss;
	static int sol;
	
	static void powerSet(boolean[] sel, int idx) {
		if(sel.length == idx) {
			// 트루면 1번 계단, 펄스면 2번 계단
			int[] stair1 = new int[10];
			int size1 = 0;
			int[] stair2 = new int[10];
			int size2 = 0;
			
			int t1 = ss[0].t;
			int t2 = ss[1].t;
			
			for(int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					int dist = Math.abs(ss[0].x - ps[i].x) + Math.abs(ss[0].y - ps[i].y); 
					stair1[size1++] = dist + t1 + 1;
				}
				else {
					int dist = Math.abs(ss[1].x - ps[i].x) + Math.abs(ss[1].y - ps[i].y); 
					stair2[size2++] = dist + t2 + 1;
				}
			}
			
			Arrays.sort(stair1);
			Arrays.sort(stair2);
			
			for(int i = 10 - size1; i < 7; i++) {
				int n = i + 3;
				if(n >= 10)
					break;
				if(stair1[n] - stair1[i] < t1)
					stair1[n] = stair1[i] + t1;
			}
			
			for(int i = 10 - size2; i < 7; i++) {
				int n = i + 3;
				if(n >= 10)
					break;
				if(stair2[n] - stair2[i] < t2)
					stair2[n] = stair2[i] + t2;
			}
			
			if(size1 == 0)
				sol = Math.min(sol, stair2[9]);
			else if(size2 == 0)
				sol = Math.min(sol, stair1[9]);
			else
				sol = Math.min(sol, Math.max(stair1[9], stair2[9]));
			
			return;
		}
		
		sel[idx] = true;
		powerSet(sel, idx + 1);
		sel[idx] = false;
		powerSet(sel, idx + 1);
	}
}