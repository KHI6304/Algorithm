package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] {0, 0});
		
		for(int i = 0; i < N; i++) {
			String inp = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = inp.charAt(j) - '0';
				if(map[i][j] == 1)
					list.add(new int[] {i, j});
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			int[] tmp = list.get(i);
			bfs(cpy(map, new int[N][M]), tmp[0], tmp[1]);
		}
		
		System.out.println(sol == Integer.MAX_VALUE ? -1 : sol);
	}
	
	static int N;
	static int M;
	static int sol = Integer.MAX_VALUE;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int[][] cpy(int[][] src, int[][] tar) {
		for(int i = 0; i < src.length; i++) {
			for(int j = 0; j < src[0].length; j++) {
				tar[i][j] = src[i][j];
			}
		}
		return tar;
	}
	
	static void bfs(int[][] map, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		map[x][y] -= 1;
		q.add(new int[] {0, 0, 1});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];
				int num = tmp[2];
				
				if(inRange(nx, ny))
					continue;
				
				if(nx == N - 1 && ny == M - 1)
					sol = Math.min(sol, num + 1);
				
				if(map[nx][ny] == 0 && !visited[nx][ny]) {
					q.add(new int[] {nx, ny, num + 1});
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	static boolean inRange(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= N || ny >= M;
	}
}