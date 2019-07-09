package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15686 {
	static class Chicken {
		int x;
		int y;
		
		public Chicken(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class House {
		int x;
		int y;
		
		public House(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		hs = new House[100];
		cs = new Chicken[13];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					hs[Hidx++] = new House(i, j);
				else if(map[i][j] == 2)
					cs[Cidx++] = new Chicken(i, j);
			}
		}
		
		comb(new Chicken[M], 0, 0);
		System.out.println(sol);
	}
	
	static int N;
	static int M;
	static int Hidx = 0;
	static int Cidx = 0;
	static House[] hs;
	static Chicken[] cs;
	static int[][] map;
	static int sol = Integer.MAX_VALUE;
	
	static void comb(Chicken[] sel, int idx, int cnt) {
		if(sel.length == cnt) {
			int tmpSum = 0;
			for(int i = 0; i < Hidx; i++) {
				int tmp = Integer.MAX_VALUE;
				for(int j = 0; j < sel.length; j++) {
					int tmpDst = Math.abs(hs[i].x - sel[j].x) + Math.abs(hs[i].y - sel[j].y);
					tmp = Math.min(tmp, tmpDst);
				}
				tmpSum += tmp;
			}
			
			sol = Math.min(sol, tmpSum);
			return;
		}
		if(Cidx == idx) {
			return;
		}
		
		sel[cnt] = cs[idx];
		comb(sel, idx + 1, cnt + 1);
		comb(sel, idx + 1, cnt);
	}
}