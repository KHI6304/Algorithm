package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main16954 {
	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[8][8];
		for(int i = 0; i < 8; i++)
			map[i] = br.readLine().toCharArray();
		
		q.add(new Node(7, 0));
		
		if(moveWall())
			System.out.println(1);
		else
			System.out.println(0);
	}
	
	private static char[][] map;
	private static Queue<Node> q = new LinkedList<>();
	
	private static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	private static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	
	private static boolean moveWall() {
		while(true) {
			// 유저 이동
			if(BFS()) return true;
			
			if(q.size() == 0) return false;
			
			// 벽이동
			for(int c = 0; c < 8; c++)
				map[7][c] = '.';
			
			for(int r = 6; r >= 0; r--) {
				for(int c = 0; c < 8; c++) {
					map[r + 1][c] = map[r][c];
					
					map[r][c] = '.';
				}
			}
		}
	}
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < 8 && ny < 8;
	}
	
	private static boolean BFS() {
		int size = q.size();
		
		for(int i = 0; i < size; i++) {
			Node tmp = q.poll();
			
			if(map[tmp.x][tmp.y] == '#') continue;
			if(tmp.x == 0 && tmp.y == 7) return true;
			
			for(int d = 0; d < 9; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || map[nx][ny] == '#') continue;
				
				q.add(new Node(nx, ny));
			}
		}
		return false;
	}
}