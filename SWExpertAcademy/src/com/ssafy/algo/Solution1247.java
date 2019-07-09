package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1247 {
	static class Place {
		int x;
		int y;
		
		Place() {}
		Place(int _x, int _y) {
			x = _x;
			y = _y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Place company = new Place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Place home = new Place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			Place[] ps = new Place[N];
			for(int i = 0; i < N; i++)
				ps[i] = new Place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			ans = Integer.MAX_VALUE;
			perm(company, home, ps, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static int ans = Integer.MAX_VALUE;
	static void perm(Place company, Place home, Place[] ps, int idx) {
		if(idx == ps.length) {
			int distance = 0;
			distance += Math.abs(company.x - ps[0].x) + Math.abs(company.y - ps[0].y);
			
			for(int i = 0; i < ps.length - 1; i++)
				distance += Math.abs(ps[i].x - ps[i + 1].x) + Math.abs(ps[i].y - ps[i + 1].y);
			
			distance += Math.abs(home.x - ps[ps.length - 1].x) + Math.abs(home.y - ps[ps.length - 1].y);
			
			if(ans > distance)
				ans = distance;
			return;
		}
		
		for(int i = idx; i < ps.length; i++) {
			swap(ps, idx, i);
			perm(company, home, ps, idx + 1);
			swap(ps, idx, i);
		}
	}
	
	static void swap(Place[] ps, int a, int b) {
		Place tmp = ps[a];
		ps[a] = ps[b];
		ps[b] = tmp;
	}
}