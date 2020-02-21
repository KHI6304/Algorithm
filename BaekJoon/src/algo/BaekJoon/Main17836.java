package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17836 {
	private static class Node {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		Row = Integer.parseInt(st.nextToken());
		Col = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[Row + 1][Col + 1];
		for(int r = 1; r <= Row; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c =1; c <= Col; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		ans = Integer.MAX_VALUE;
		BFS();
		findSword();
		
		System.out.println(ans > T ? "Fail" : ans);
	}
	
	private static int Row;
	private static int Col;
	private static int T;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int ans;
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 1 && ny >= 1 && nx <= Row && ny <= Col; 
	}
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static void BFS() {
		visited = new boolean[Row + 1][Col + 1];
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 1, 0));
		visited[1][1] = true;
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			if(tmp.x == Row && tmp.y == Col) {
				ans = tmp.cnt;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || map[nx][ny] == 1 || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				q.add(new Node(nx, ny, tmp.cnt + 1));
			}
		}
	}
	
	private static void findSword() {
		visited = new boolean[Row + 1][Col + 1];
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 1, 0));
		visited[1][1] = true;
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			if(map[tmp.x][tmp.y] == 2) {
				swordBFS(tmp);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || map[nx][ny] == 1 || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				q.add(new Node(nx, ny, tmp.cnt + 1));
			}
		}
	}
	
	private static void swordBFS(Node n) {
		visited = new boolean[Row + 1][Col + 1];
		
		Queue<Node> q = new LinkedList<>();
		q.add(n);
		visited[n.x][n.y] = true;
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			if(tmp.x == Row && tmp.y == Col) {
				ans = Math.min(ans, tmp.cnt);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				q.add(new Node(nx, ny, tmp.cnt + 1));
			}
		}
	}
}