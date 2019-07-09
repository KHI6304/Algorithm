package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main14620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		solve(new ArrayList<Pos>(), 0, 3);
		
		System.out.println(sol);
	}
	
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	static int N;
	static int[][] map;
	static int sol = Integer.MAX_VALUE;
	
	static void solve(List<Pos> list, int cost, int cnt) {
		for(int r = 1; r < N - 1; r++) {
			for(int c = 1; c < N - 1; c++) {
				if(cnt == 0) {
					sol = Math.min(sol, cost);
					list.remove(2);
					return;
				}
				
				for(int i = 0; i < list.size(); i++) {
					int x = list.get(i).x;
					int y = list.get(i).y;
					
					int distance = (int) (Math.pow(Math.abs(x - r), 2) + Math.pow(Math.abs(y - c), 2));
					
					if(distance < 5) {
						list.add(new Pos(r, c));
						
						cost += map[r][c];
						for(int d = 0; d < 4; d++) {
							int nr = r + dx[d];
							int nc = c + dy[d];
							
							cost += map[nr][nc];
						}
						
						solve(list, cost, cnt - 1);
						
						list.remove(list.size() - 1);
					}
				}
			}
		}
	}
	
	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}