package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main05427 {
	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			Col = Integer.parseInt(st.nextToken());
			Row = Integer.parseInt(st.nextToken());
			map = new char[Row][Col];
			
			user = new LinkedList<>();
			fires = new LinkedList<>();
			for(int r = 0; r < Row; r++) {
				map[r] = br.readLine().toCharArray();
				for(int c = 0; c < Col; c++) {
					if(map[r][c] == '@')
						user.add(new Node(r, c));
					if(map[r][c] == '*')
						fires.add(new Node(r, c));
				}
			}
			
			BFS();
			System.out.println(cnt != -1 ? cnt : "IMPOSSIBLE");
		}
	}
	
	private static int Row, Col;
	private static char[][] map;
	private static boolean[][] visited;
	private static Queue<Node> user;
	private static Queue<Node> fires;
	private static int cnt;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < Row && ny < Col;
	}
	
	private static void BFS() {
		visited = new boolean[Row][Col];
		cnt = 0;
		boolean flag = true;
		
		while(flag) {
			int userSize = user.size();
			int firesSize = fires.size();
			cnt++;
			
			if(userSize == 0) {
				cnt = -1;
				break;
			}
			
			while(firesSize != 0) {
				Node fire = fires.poll();
				firesSize--;
				
				for(int d = 0; d < 4; d++) {
					int nx = fire.x + dx[d];
					int ny = fire.y + dy[d];
					
					if(!inRange(nx, ny) || map[nx][ny] == '#' || map[nx][ny] == '*') continue;
					
					map[nx][ny] = '*';
					fires.add(new Node(nx, ny));
				}
			}
			
			while(userSize != 0 && flag) {
				Node u = user.poll();
				userSize--;
				visited[u.x][u.y] = true;
				
				for(int d = 0; d < 4; d++) {
					int nx = u.x + dx[d];
					int ny = u.y + dy[d];
					
					if(!inRange(nx, ny)) {
						flag = false;
						break;
					}
					
					if(map[nx][ny] != '.' || visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					user.add(new Node(nx, ny));
				}
			}
		}
	}
}