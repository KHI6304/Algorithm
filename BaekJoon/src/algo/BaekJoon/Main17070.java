package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17070 {
	static class Pipe {
		int x;
		int y;
		int d;
		
		public Pipe(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		q = new LinkedList<>();
		q.add( new Pipe(1, 2, 1) );
		sol = 0;
		DFS();
		
		System.out.println(sol);
	}
	
	static int N;
	static int[][] map;
	static Queue<Pipe> q;
	static int sol;
	
	static void DFS() {
		while(!q.isEmpty()) {
			Pipe tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int d = tmp.d;
			
			if(x == N && y == N)
				sol++;
			
			if( right(tmp)) {
				q.add( new Pipe(x, y + 1, 1) );
			}
			
			if( down(tmp)) {
				q.add( new Pipe(x + 1, y, 3) );
			}
			
			if( cross(tmp)) {
				q.add( new Pipe(x + 1, y + 1, 2) );
			}
		}
	}
	
	// 오른쪽 방향
	static boolean right(Pipe p) {
		if(p.d == 3)
			return false;
		else {
			int nx = p.x;
			int ny = p.y + 1;
			
			if( !inRange(nx, ny) || map[nx][ny] != 0 )
				return false;
			return true;
		}
	}

	// 아래쪽 방향
	static boolean down(Pipe p) {
		if (p.d == 1)
			return false;
		else {
			int nx = p.x + 1;
			int ny = p.y;

			if ( !inRange(nx, ny) || map[nx][ny] != 0)
				return false;
			return true;
		}
	}
	
	// 대각선 방향
	static boolean cross(Pipe p) {
		int nx = p.x;
		int ny = p.y;
		
		for(int i = 0; i < 2; i++) {
			int tmpx = nx;
			int tmpy = ny;
			tmpx += i;
			
			for(int j = 0; j < 2; j++) {
				tmpy += j;
				
				if ( !inRange(tmpx, tmpy) || map[tmpx][tmpy] != 0)
					return false;
			}
		}
		
		return true;
	}

	// 범위 검사
	static boolean inRange(int nx, int ny) {
		return nx > 0 && ny > 0 && nx <= N && ny <= N;
	}
}