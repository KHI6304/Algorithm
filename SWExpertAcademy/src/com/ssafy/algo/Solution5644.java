package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5644 {
	static class BC implements Comparable<BC> {
		int y;
		int x;
		int c;
		int p;
		
		public BC(int y, int x, int c, int p) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}

		@Override
		public int compareTo(BC o) {
			return o.p - p;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());	// 이동 시간
			int A = Integer.parseInt(st.nextToken());	// BC의 개수
			bcs = new BC[A];
			
			Queue<Integer> a = new LinkedList<>();
			Queue<Integer> b = new LinkedList<>();
			
			a.add(0);
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++)
				a.add(Integer.parseInt(st.nextToken()));
			
			b.add(0);
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++)
				b.add(Integer.parseInt(st.nextToken()));
			
			for(int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				bcs[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// 충전량을 기준으로 내림 차순 정렬
			Arrays.sort(bcs);
			
			sol = 0;
			int ax = 1, ay = 1;
			int bx = 10, by = 10;
			
			// 정해진 이동 횟수 만큼 정해진 이동 방향에 따라 한 칸씩 이동
			for(int i = 0; i <= M; i++) {
				int aMove = a.poll();
				int bMove = b.poll();
				
				ax += dx[aMove];
				ay += dy[aMove];
				
				bx += dx[bMove];
				by += dy[bMove];
				
				// 이동 후 검사
				solve(ax, ay, bx, by);
			}
			
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int sol;
	static BC[] bcs;
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, 1, 0, -1};
	
	static void solve(int anx, int any, int bnx, int bny) {
		List<Integer> aList = new LinkedList<>();
		List<Integer> bList = new LinkedList<>();
		
		// A와 B의 현재 위치에서 범위 안에 있는 충전기가 있다면 각 자의 리스트에 저장
		for(int i = 0; i < bcs.length; i++) {
			if( inRange(bcs[i], anx, any) )
				aList.add(i);
			
			if( inRange(bcs[i], bnx, bny) )
				bList.add(i);
		}
		
		if(aList.size() == 0 && bList.size() == 0)
			return;
		
		// A와 B 모두 한 개의 충전기 만 범위에 있고, 그 것이 똑같을 경우
		if(aList.size() == 1 && bList.size() == 1 && aList.get(0) == bList.get(0)) {
			sol += bcs[aList.get(0)].p;
			return;
		}
		
		// A와 B 둘 중 하나만 범위 안의 충전기가 없는 경우
		if(aList.size() == 0) {
			sol += bcs[bList.get(0)].p;
			return;
		}
		else if(bList.size() == 0) {
			sol += bcs[aList.get(0)].p;
			return;
		}
		
		// A와 B 둘중 하나는 한개의 충전소만 범위 안에 있고 나머지는 2개 이상의 충전소 범위 안에 드는 경우
		int sel = -1;
		if(aList.size() == 1 && bList.size() > 1) {
			sel = aList.get(0);
			sol += bcs[sel].p;
			if(bList.get(0) == sel)
				sol += bcs[bList.get(1)].p;
			else
				sol += bcs[bList.get(0)].p;
			return;
		}
		
		if(bList.size() == 1 && aList.size() > 1) {
			sel = bList.get(0);
			sol += bcs[sel].p;
			if(aList.get(0) == sel)
				sol += bcs[aList.get(1)].p;
			else
				sol += bcs[aList.get(0)].p;
			return;
		}
		
		// 겹쳐진 경우를 고려
		if(aList.get(0) != bList.get(0))
			sol += bcs[aList.get(0)].p + bcs[bList.get(0)].p;
		else {
			if(aList.get(1) < bList.get(1))
				sol += bcs[aList.get(1)].p + bcs[bList.get(0)].p;
			else
				sol += bcs[aList.get(0)].p + bcs[bList.get(1)].p;
		}
	}
	
	static boolean inRange(BC bc, int nx, int ny) {
		return Math.abs(bc.x - nx) + Math.abs(bc.y - ny) <= bc.c;
	}
}