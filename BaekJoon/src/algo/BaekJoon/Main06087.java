package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main06087 {
	private static class C {
		int x;
		int y;
		
		public C(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static class P {
		int x;
		int y;
		int cnt;
		int currentD;
		
		public P(int x, int y, int cnt, int currentD) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.currentD = currentD;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new int[R][C];
		cs = new C[2];
		int cIdx = 0;
		
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				check[i][j] = Integer.MAX_VALUE;
				if(map[i][j] == 'C')
					cs[cIdx++] = new C(i, j);
			}
		}
		
		solve();
		System.out.println(check[ cs[1].x ][ cs[1].y ]);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int R, C;
	static char[][] map;
	static int[][] check;
	static C[] cs;
	static int sol;
	
	static void solve() {
		Queue<P> q = new LinkedList<>();
		for(int i = 0; i < 4; i++)
			q.add(new P(cs[0].x, cs[0].y, 0, i));
		
		while(!q.isEmpty()) {
			P tmp = q.poll();
			
			if(tmp.x == cs[1].x && tmp.y == cs[1].y && check[tmp.x][tmp.y] > tmp.cnt)
				check[tmp.x][tmp.y] = tmp.cnt;
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny))
					continue;
				
				if(map[nx][ny] != '*') {
					if(tmp.currentD == d) {
						if( check[nx][ny] >= tmp.cnt ) {
							q.add(new P(nx, ny, tmp.cnt, d));
							check[nx][ny] = tmp.cnt;
						}
					}
					else {
						if( check[nx][ny] >= tmp.cnt + 1 ) {
							q.add(new P(nx, ny, tmp.cnt + 1, d));
							check[nx][ny] = tmp.cnt + 1;
						}
					}
				}
			}
		}
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < R && ny < C;
	}
}