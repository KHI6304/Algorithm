package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main06593 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0)
				break;
			
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			int[] start = null;
			int[] end = null;
			sol = 0;
			
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R; j++) {
					map[i][j] = br.readLine().toCharArray();
					for(int k = 0; k < C; k++) {
						if(map[i][j][k] == 'S')
							start = new int[] {i, j, k};
						if(map[i][j][k] == 'E')
							end = new int[] {i, j, k};
					}
				}
				br.readLine();
			}
			
			BFS(start, end);
			
			if(sol == 0)
				System.out.println("Trapped!");
			else
				System.out.println("Escaped in " + sol + " minute(s).");
		}
	}
	
	static int[] dz = {-1, 1, 0, 0, 0, 0};
	static int[] dx = {0, 0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, 0, -1, 1};
	static int L;
	static int R;
	static int C;
	static char[][][] map;
	static boolean[][][] visited;
	static int sol;
	
	static void BFS(int[] start, int[] end) {
		Queue<Pos> q = new LinkedList<>();
		Pos p = new Pos(start[0], start[1], start[2], 0);
		visited[p.z][p.x][p.y] = true;
		q.add(p);
		boolean flag = true;
		
		while(!q.isEmpty() && flag) {
			Pos tmp = q.poll();
			
			for(int d = 0; d < 6; d++) {
				Pos np = new Pos(tmp.z + dz[d], tmp.x + dx[d], tmp.y + dy[d], tmp.cnt + 1);
				
				if(!inRange(np.z, np.x, np.y))
					continue;
				
				if(np.z == end[0] && np.x == end[1] && np.y == end[2]) {
					sol = np.cnt;
					flag = false;
					break;
				}
				
				if(!visited[np.z][np.x][np.y] && map[np.z][np.x][np.y] == '.') {
					visited[np.z][np.x][np.y] = true;
					q.add(np);
				}
			}
		}
	}
	
	static boolean inRange(int nz, int nx, int ny) {
		return nz >= 0 && nx >= 0 && ny >= 0 && nz < L && nx < R && ny < C;
	}
	
	static class Pos {
		int z;
		int x;
		int y;
		int cnt;
		
		public Pos(int z, int x, int y, int cnt) {
			this.z = z;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}