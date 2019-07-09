package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1494 {
	static class Worm {
		int x;
		int y;
		
		public Worm(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			ws = new Worm[N];
			selWorm = new Worm[N / 2];
			notSelWorm = new Worm[N / 2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ws[i] = new Worm(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			sol = Long.MAX_VALUE;
			comb(new boolean[N], 0, 0);
			
			sb.append("#").append(tc).append(" ").append(sol).append("\n");
		}
		System.out.print(sb);
	}
	
	static Worm[] ws;
	static Worm[] selWorm;
	static Worm[] notSelWorm;
	static int N;
	static long sol;
	static void comb(boolean[] sel, int idx, int cnt) {
		if(sel.length == idx) {
			if (cnt == (N / 2)) {
				int selIdx = 0;
				int notSelIdx = 0;
				
				for (int i = 0; i < sel.length; i++) {
					if (sel[i])
						selWorm[selIdx++] = ws[i];
					else
						notSelWorm[notSelIdx++] = ws[i];
				}
				
				long sum = 0;
				long x = 0;
				long y = 0;
				for (int i = 0; i < (N / 2); i++) {
					x += (selWorm[i].x - notSelWorm[i].x);
					y += (selWorm[i].y - notSelWorm[i].y);
				}
				sum += x * x + y * y;
				
				if(sum < sol)
					sol = sum;
			}
			return;
		}
		
		sel[idx] = true;
		comb(sel, idx + 1, cnt + 1);
		sel[idx] = false;
		comb(sel, idx + 1, cnt);
	}
}