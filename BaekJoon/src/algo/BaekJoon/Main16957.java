package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16957 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		cntMap = new int[R][C];
		pq = new PriorityQueue<>();
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				pq.add(new Pos(i, j, map[i][j]));
				cntMap[i][j] = 1;
			}
		}
		
		BFS();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++)
				System.out.print(cntMap[i][j] + " ");
			System.out.println();
		}
	}
	
	static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	static int R, C;
	static int[][] map;
	static int[][] cntMap;
	static PriorityQueue<Pos> pq;
	
	static void BFS() {
		
		while(!pq.isEmpty()) {
			Pos tmp = pq.poll();
			int x = tmp.x;
			int y = tmp.y;			
			
			int changeX = 0, changeY = 0, ok = 0; 
			int nVal = map[x][y];
			for(int d = 0; d < 8; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if( !inRange(nx, ny) )
					continue;
				
				if( map[x][y] > map[nx][ny] ) {
					if( nVal > map[nx][ny] ) {
						nVal = map[nx][ny];
						ok = 1;
						changeX = nx;
						changeY = ny;
					}
				}
			}
			
			if(ok == 1) {
				cntMap[changeX][changeY] += cntMap[x][y];
				cntMap[x][y] = 0; 
			}
		}
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < R && ny < C;
	}
	
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		int val;
		
		public Pos(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(Pos o) {
			return o.val - val;
		}
	}
}