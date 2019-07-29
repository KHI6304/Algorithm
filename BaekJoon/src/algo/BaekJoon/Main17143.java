package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17143 {
	private static class Shark {
		int r;	// 행
		int c;	// 열
		int s;	// 속도
		int d;	// 방향
		int z;	// 크기
		boolean live;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.live = true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[R + 1][C + 1];
		sharks = new Shark[M + 1];
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			sharks[i] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			map[ sharks[i].r ][ sharks[i].c ] = i;
		}
		
		int y = 1;
		int sol = 0;
		
		while( y <= C ) {
			int x = 1;
			while( x <= R ) {
				if( map[x][y] != 0 ) {
					sharks[ map[x][y] ].live = false;
					sol += sharks[ map[x][y] ].z;
					map[x][y] = 0;
					break;
				}
				x++;
			}
			
			map = new int[R + 1][C + 1];
			for(int i = 1; i <= M; i++) {
				if( !sharks[i].live )
					continue;
				solve(map, i);
			}
//			for(int i = 1; i <= R; i++) {
//				for(int j = 1; j <= C; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(y);
//			System.out.println();
//			System.out.println();
			y++;
		}
		
		System.out.println(sol);
	}
	
	private static int R;
	private static int C;
	private static Shark[] sharks;
	private static int[] dr = {0, -1, 1, 0, 0};
	private static int[] dc = {0, 0, 0, 1, -1};
	
	private static void solve(int[][] map, int idx) {
		int r = sharks[idx].r;
		int c = sharks[idx].c;
		int d = sharks[idx].d;
		int s = sharks[idx].s;
		
		int nr = r + dr[d] * s;
		int nc = c + dc[d] * s;
		while(true) {
			if( inRange(nr, nc) ) {
				if( map[nr][nc] != 0 ) {
					if( sharks[ map[nr][nc] ].z < sharks[idx].z ) {
						sharks[ map[nr][nc] ].live = false;
						sharks[idx].r = nr;
						sharks[idx].c = nc;
						sharks[idx].d = d;
						map[nr][nc] = idx;
					}
					else {
						sharks[idx].live = false;
					}
				}
				else {
					map[nr][nc] = idx;
					sharks[idx].r = nr;
					sharks[idx].c = nc;
					sharks[idx].d = d;
				}
				break;
			}
			else {
				switch(d) {
				case 1:
					d = 2;
					s = s - r + 1;
					r = 1;
					nr = 1 + dr[d] * s;
					break;
				case 2:
					d = 1;
					s = s - R + r;
					r = R;
					nr = R + dr[d] * s;
					break;
				case 3:
					d = 4;
					s = s - C + c;
					c = C;
					nc = C + dc[d] * s;
					break;
				case 4:
					d = 3;
					s = s - c + 1;
					c = 1;
					nc = 1 + dc[d] * s;
					break;
				}
			}
		}
	}
	
	private static boolean inRange(int nr, int nc) {
		return nr >= 1 && nc >= 1 && nr <= R && nc <= C;
	}
}