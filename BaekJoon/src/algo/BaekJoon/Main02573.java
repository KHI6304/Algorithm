package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02573 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		Row = Integer.parseInt(st.nextToken());
		Col = Integer.parseInt(st.nextToken());
		int[][] map = new int[Row][Col];
		List<Pos> Iceberg = new ArrayList<>();
		
		for(int r = 0; r < Row; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < Col; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] != 0)
					Iceberg.add(new Pos(r, c));
			}
		}
		
		boolean endFlag = true;
		boolean printZero = false;
		int sol = 1;
		
		while(endFlag) {
			int[][] damageMap = new int[Row][Col];
			
			for(int i = 0; i < Iceberg.size(); i++) {
				int x = Iceberg.get(i).x;
				int y = Iceberg.get(i).y;
				
				for(int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(map[nx][ny] == 0)
						damageMap[x][y]++;
				}
			}
			
			for(int i = 0; i < Iceberg.size(); i++) {
				int x = Iceberg.get(i).x;
				int y = Iceberg.get(i).y;
				
				if(map[x][y] - damageMap[x][y] <= 0) {
					map[x][y] = 0;
					Iceberg.remove(i--);
					
				}
				else
					map[x][y] -= damageMap[x][y];
			}
			
			if(Iceberg.size() == 0) {
				printZero = true;
				break;
			}
			
			remain = 1;
			BFS(map, Iceberg.get(0));
			if(remain == Iceberg.size())
				sol++;
			else
				endFlag = false;
		}
		
		if(printZero)
			System.out.println(0);
		else
			System.out.println(sol);
	}
	
	static int Row, Col;
	static int remain;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void BFS(int[][] map, Pos p) {
		boolean visited[][] = new boolean[Row][Col];
		Queue<Pos> q = new LinkedList<>();
		q.add(p);
		visited[p.x][p.y] = true;
		
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny))
					continue;
				
				if(map[nx][ny] != 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Pos(nx, ny));
					remain++;
				}
			}
		}
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < Row && ny < Col;
	}
	
	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}