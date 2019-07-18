package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02146 {
	static class Pos {
		int x;
		int y;
		int continent;
		
		public Pos(int x, int y, int continent) {
			this.x = x;
			this.y = y;
			this.continent = continent;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int continent = 0;
		int sepa = 0;
		list = new LinkedList<>();
		size = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 || visited[i][j])
					continue;
				coloring(new Pos(i, j, ++continent));
			}
		}
		
		int sol = Integer.MAX_VALUE;
		int idx = 0;
		for(int i = 0; i < size.size(); i++) {
			int sizeNum = size.get(0);
			
			for(int j = 0; j < sizeNum; j++) {
				idx += j;
				
			}
		}
	}
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static List<Pos> list;
	static List<Integer> size;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void coloring(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		q.add(p);
		list.add(p);
		int sizeNum = 0;
		
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int continent = tmp.continent;
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(!inRange(nx, ny))
					continue;
				
				if(!visited[nx][ny] && map[nx][ny] != 0) {
					Pos ptmp = new Pos(nx, ny, continent);
					q.add(ptmp);
					visited[nx][ny] = true;
					sizeNum++;
					list.add(ptmp);
				}
			}
		}
		
		size.add(sizeNum);
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
}