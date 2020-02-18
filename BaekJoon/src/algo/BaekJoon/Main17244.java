package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17244 {
	private static class Dot {
		int x, y, cnt;

		public Dot(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		Col = Integer.parseInt(st.nextToken());
		Row = Integer.parseInt(st.nextToken());
		
		map = new char[Row][Col];
		xs = new ArrayList<>();
		for(int r = 0; r < Row; r++) {
			map[r] = br.readLine().toCharArray();
			for(int c = 0; c < Col; c++)
				if(map[r][c] == 'X')
					xs.add(new Dot(r, c, 0));
				else if(map[r][c] == 'E')
					E = new Dot(r, c, 0);
				else if(map[r][c] == 'S')
					S = new Dot(r, c, 0);
		}
		
		if(xs.size() ==0) {
			visited = new boolean[Row][Col];
			System.out.println(BFS(S, E));
			return;
		}
		
		idx = new int[xs.size()];
		for(int i = 0; i < idx.length; i++)
			idx[i] = i;
		
		ans = Integer.MAX_VALUE;
		perm(0);
		System.out.println(ans);
	}
	
	private static int Row;
	private static int Col;
	private static char[][] map;
	private static boolean[][] visited;
	private static ArrayList<Dot> xs;
	private static int[] idx;
	private static Dot S;
	private static Dot E;
	private static int ans;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static void perm(int index) {
		if(index == idx.length) {
			int sum = 0;
			
			visited = new boolean[Row][Col];
			sum += BFS(S, xs.get(idx[0]));
			for(int i = 1; i < idx.length; i++) {
				visited = new boolean[Row][Col];
				sum += BFS(xs.get(idx[i - 1]), xs.get(idx[i]));
			}
			
			visited = new boolean[Row][Col];
			sum += BFS(xs.get(idx[idx.length - 1]), E);
			
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i = index; i < idx.length; i++) {
			swap(i, index);
			perm(index + 1);
			swap(i, index);
		}
	}
	
	private static void swap(int i, int j) {
		int tmp = idx[i];
		idx[i] = idx[j];
		idx[j] = tmp;
	}
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < Row && ny < Col;
	}
	
	private static int BFS(Dot start, Dot end) {
		Queue<Dot> q = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y] = true;
		
		while(!q.isEmpty()) {
			Dot tmp = q.poll();
			
			if(tmp.x == end.x && tmp.y == end.y)
				return tmp.cnt;
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || visited[nx][ny] || map[nx][ny] == '#') continue;
				
				visited[nx][ny] = true;
				q.add(new Dot(nx, ny, tmp.cnt + 1));
			}
		}
		
		return 0;
	}
}