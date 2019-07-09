package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main15683 {
	static class CCTV {
		int x;
		int y;
		int n;
		
		public CCTV(int x, int y, int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		Row = Integer.parseInt(st.nextToken());
		Col = Integer.parseInt(st.nextToken());
		map = new int[Row][Col];
		
		for(int i = 0; i < Row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < Col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6)
					cctvs.add(new CCTV(i, j, map[i][j]));
			}
		}
		
		solve(map, 0);
		System.out.println(sol);
	}
	
	static int Row, Col;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int sol = Integer.MAX_VALUE;
	static List<CCTV> cctvs = new LinkedList<>();
	static String[][] arr = {
		{"1", "2", "3", "4"},
		{"24", "13"},
		{"12", "23", "34", "14"},
		{"124", "123", "234", "134"},
		{"1234"}
	};
	
	static void solve(int[][] copy, int idx) {
		if(idx == cctvs.size()) {
			search(copy);
			return;
		}
		
		for(int i = 0; i < arr[cctvs.get(idx).n - 1].length; i++) {
			int[][] copycopy = new int[Row][Col];
			deepCopy(copy, copycopy);
			
			if( arr[cctvs.get(idx).n - 1][i].contains("1") )
				U(copycopy, cctvs.get(idx).x, cctvs.get(idx).y);
			if( arr[cctvs.get(idx).n - 1][i].contains("2") )
				R(copycopy, cctvs.get(idx).x, cctvs.get(idx).y);
			if( arr[cctvs.get(idx).n - 1][i].contains("3") )
				D(copycopy, cctvs.get(idx).x, cctvs.get(idx).y);
			if( arr[cctvs.get(idx).n - 1][i].contains("4") )
				L(copycopy, cctvs.get(idx).x, cctvs.get(idx).y);
			
			solve(copycopy, idx + 1);
		}
	}
	
	static void deepCopy(int[][] src, int[][] copy) {
		for(int i = 0; i < Row; i++)
			for(int j = 0; j < Col; j++)
				copy[i][j] = src[i][j];
	}
	
	static void search(int[][] copy) {
		int tmp = 0;
		for(int i = 0; i < Row; i++)
			for(int j = 0; j < Col; j++)
				if(copy[i][j] == 0)
					tmp++;
		sol = Math.min(sol, tmp);
	}
	
	static boolean isWatch(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < Row && ny < Col && map[nx][ny] != 6;
	}
	
	static void U(int[][] copy, int x, int y) {
		int nx = x + dx[0];
		int ny = y + dy[0];
		
		while(true) {
			if( !isWatch(nx, ny) )
				return;
			
			if(copy[nx][ny] == 0)
				copy[nx][ny] = -1;
			
			nx += dx[0];
			ny += dy[0];
		}
	}
	
	static void D(int[][] copy, int x, int y) {
		int nx = x + dx[1];
		int ny = y + dy[1];
		
		while(true) {
			if( !isWatch(nx, ny) )
				return;
			
			if(copy[nx][ny] == 0)
				copy[nx][ny] = -1;
			
			nx += dx[1];
			ny += dy[1];
		}
	}
	
	static void L(int[][] copy, int x, int y) {
		int nx = x + dx[2];
		int ny = y + dy[2];
		
		while(true) {
			if( !isWatch(nx, ny) )
				return;
			
			if(copy[nx][ny] == 0)
				copy[nx][ny] = -1;
			
			nx += dx[2];
			ny += dy[2];
		}
	}
	
	static void R(int[][] copy, int x, int y) {
		int nx = x + dx[3];
		int ny = y + dy[3];
		
		while(true) {
			if( !isWatch(nx, ny) )
				return;
			
			if(copy[nx][ny] == 0)
				copy[nx][ny] = -1;
			
			nx += dx[3];
			ny += dy[3];
		}
	}
	
}