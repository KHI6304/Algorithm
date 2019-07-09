package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main07562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			int[] pos = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0};
			st = new StringTokenizer(br.readLine());
			goal = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			
			q = new LinkedList<>();
			q.add(pos);
			sol = 0;
			BFS();
			
			System.out.println(sol);
		}
	}
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dx = {0, -1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {0, -2, -1, 1, 2, 2, 1, -1, -2};
	static int sol;
	static int[] goal;
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
	
	static void BFS() {
		int tmpCnt = 0;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			visited[tmp[0]][tmp[1]] = true;
			
			for(int i = 0; i < dx.length; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				int cnt = tmp[2];
				
				if(!inRange(nx, ny))
					continue;
				
				if(nx == goal[0] && ny == goal[1]) {
					if(tmpCnt == 0)
						sol = cnt;
					else
						sol = cnt + 1;
					while(!q.isEmpty())
						q.poll();
					break;
				}
				tmpCnt++;
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny, cnt + 1});
				}
			}
		}
	}
	
}