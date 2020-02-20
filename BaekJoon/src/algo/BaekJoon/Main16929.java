package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16929 {
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
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int r = 0; r < N; r++)
			map[r] = br.readLine().toCharArray();
		
		for(int r = 0; r < N - 1; r++) {
			for(int c = 0; c < M - 1; c++) {
				visited = new boolean[N][M];
				
				if(BFS(new Node(r, c))) {
					System.out.println("Yes");
					return;
				}
			}
		}
		
		System.out.println("No");
	}
	
	private static int N;
	private static int M;
	private static char[][] map;
	private static boolean[][] visited;
	
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < M;
	}
	
	private static boolean BFS(Node n) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n.x, n.y + 1));
		visited[n.x][n.y] = true;
		char c = map[n.x][n.y];
		if(map[n.x][n.y + 1] != c) return false;
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || map[nx][ny] != c) continue;
				
				if(nx == n.x && ny == n.y && d != 3) continue;
				if(nx == n.x && ny == n.y && d == 3)
					return true;
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				q.add(new Node(nx, ny));
			}
		}
		return false;
	}
}