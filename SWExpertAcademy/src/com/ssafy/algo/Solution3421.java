package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution3421 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			list = new LinkedList<>();
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				int[] tmp = {x, y};
				list.add(tmp);
			}
			sol = 0;
			powerSet(new boolean[N], 0);
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int sol;
	static List<int[]> list;
	static void powerSet(boolean[] sel, int idx) {
		if(sel.length == idx) {
			for(int i = 0; i < list.size(); i++) {
				int[] tmp = list.get(i);
				if(sel[tmp[0] - 1] && sel[tmp[1] - 1]) {
					return;
				}
			}
			sol++;
			return;
		}
		
		sel[idx] = true;
		powerSet(sel, idx + 1);
		sel[idx] = false;
		powerSet(sel, idx + 1);
	}
}