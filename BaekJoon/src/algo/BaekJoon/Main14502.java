package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502 {
	private static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		Row = Integer.parseInt(st.nextToken());
		Col = Integer.parseInt(st.nextToken());
		map = new int[Row][Col];
		copy = new int[Row][Col];
		viruses = new ArrayList<>();
		
		for(int r = 0; r < Row; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < Col; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
				if(map[r][c] == 2) viruses.add(new Dot(r, c));
			}
		}
		
		ans = Integer.MIN_VALUE;
		
		setWall(0, 0);
		
		System.out.println(ans);
	}
	
	private static int Row;
	private static int Col;
	private static int[][] map;
	private static int[][] copy;
	private static ArrayList<Dot> viruses;
	private static int ans;
	
	// 맵 복사
	private static void copyMap() {
		for(int i = 0; i < Row; i++)
			for(int j = 0; j < Col; j++)
				copy[i][j] = map[i][j];
	}
	
	private static int getSafeArea() {
		int cnt = 0;
		
		for(int r = 0; r < Row; r++)
			for(int c = 0; c < Col; c++)
				if(copy[r][c] == 0) cnt++;
		
		return cnt;
	}
	
	// 백트래킹으로 벽 3개 세우기
	private static void setWall(int start, int depth) {
		if(depth == 3) {
			copyMap();
			
			for(Dot virus : viruses)
				spreadVirus(virus);
			
			int cnt = getSafeArea();
			ans = Math.max(ans, cnt);
			return;
		}
		
		for(int i = start; i < Row * Col; i++) {
			int r = i / Col;
			int c = i % Col;
			
			if(map[r][c] == 0) {
				map[r][c] = 1;
				setWall(start + 1, depth + 1);
				map[r][c] = 0;
			}
		}
	}
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < Row && ny < Col;
	}
	
	// 바이러스 퍼뜨리기
	private static void spreadVirus(Dot virus) {
		Queue<Dot> q = new LinkedList<>();
		q.add(virus);
		
		while(!q.isEmpty()) {
			Dot tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny)) continue;
				
				if(copy[nx][ny] == 0) {
					copy[nx][ny] = 2;
					q.add(new Dot(nx, ny));
				}
			}
		}
	}
}