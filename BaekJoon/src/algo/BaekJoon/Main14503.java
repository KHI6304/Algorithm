package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14503 {
	static class Robot {
		int x;
		int y;
		int d;	// 0 : 북, 1 : 동, 2 : 남, 3 : 서
		
		public Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visited = new boolean[row][col];
		
		st = new StringTokenizer(br.readLine());
		r = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		sol = 0;
		BFS();
		System.out.println(sol);
	}
	
	static int row;
	static int col;
	static boolean[][] visited;
	static int[][] map;
	static Robot r;
	// 북, 동, 남, 서
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int sol;
	
	static void BFS() {
		Queue<Robot> q = new LinkedList<>();
		q.add(r);
		visited[r.x][r.y] = true;
		sol++;
		
		while(!q.isEmpty()) {
			Robot tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int d = tmp.d;
			
			boolean endFlag = true;
			for(int i = 1; i <= 4; i++) {
				int tmpD = (d + i * 3) % 4;
				int tmpX = x + dx[tmpD];
				int tmpY = y + dy[tmpD];
				
				if(!inRange(tmpX, tmpY))
					continue;
				
				if(!visited[tmpX][tmpY] && map[tmpX][tmpY] == 0) {
					visited[tmpX][tmpY] = true;
					q.add(new Robot(tmpX, tmpY, tmpD));
					sol++;
					endFlag = false;
					break;
				}
			}
			if(endFlag) {
				int nd = (d + 2) % 4;
				int tmpX = x + dx[nd];
				int tmpY = y + dy[nd];
				
				if(map[tmpX][tmpY] != 1) {
					endFlag = false;
					q.add(new Robot(tmpX, tmpY, d));
				}
			}
			
			if(endFlag)
				q.clear();
		}
	}
	
	static boolean inRange(int nx, int ny) {
		return nx < row && ny < col && nx >= 0;
	}
}