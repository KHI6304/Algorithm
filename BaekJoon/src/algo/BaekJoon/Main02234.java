package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02234 {
	private static class Room {
		int x, y;

		public Room(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		Col = Integer.parseInt(st.nextToken());
		Row = Integer.parseInt(st.nextToken());
		
		map = new int[Row][Col];
		for(int r = 0; r < Row; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < Col; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		roomCnt = 0;
		maxArea = Integer.MIN_VALUE;
		visited = new boolean[Row][Col];
		for(int r = 0; r < Row; r++) {
			for(int c = 0; c < Col; c++) {
				if(visited[r][c]) continue;
				
				BFS(new Room(r, c));
				roomCnt++;
			}
		}
		
		System.out.println(roomCnt);
		System.out.println(maxArea);
		
		maxArea = Integer.MIN_VALUE;
		
		for(int r = 0; r < Row; r++) {
			for(int c = 0; c < Col; c++) {
				int val = map[r][c];
				int[] d = {val & 1, val & 2, val & 4, val & 8};
						
				for(int i = 0; i < 4; i++) {
					if(d[i] == 0) continue;
					
					map[r][c] -= (int) Math.pow(2, i);
					
					visited = new boolean[Row][Col];
					BFS(new Room(r, c));
					
					map[r][c] += (int) Math.pow(2, i);
				}
				
			}
		}
		
		System.out.println(maxArea);
	}
	
	private static int Row;
	private static int Col;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int roomCnt;
	private static int maxArea;
	
	// 방향 배열 [서, 북, 동, 남]
	private static int[] dx = {0, -1, 0, 1};
	private static int[] dy = {-1, 0, 1, 0};
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < Row && ny < Col;
	}
	
	private static void BFS(Room room) {
		Queue<Room> q = new LinkedList<>();
		q.add(room);
		visited[room.x][room.y] = true;
		
		int area = 1;
		while(!q.isEmpty()) {
			Room tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int val = map[x][y];
			
			int[] d = {val & 1, val & 2, val & 4, val & 8};
			for(int i = 0; i < 4; i++) {
				if(d[i] != 0) continue;
				
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(!inRange(nx, ny) || visited[nx][ny]) continue;
				
				area++;
				visited[nx][ny] = true;
				q.add(new Room(nx, ny));
			}
		}
		
		maxArea = Math.max(maxArea, area);
	}
}