package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new int[X][Y];
		q = new LinkedList<>();
		
		for(int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < Y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 모든 세균의 위치를 큐에 저장
				if(map[i][j] == 2) {
					q.add(new int[] {i, j});
				}
			}
		}
		
		sol = 0;
		AllCase();
		
		System.out.println(sol);
	}
	
	static int X;
	static int Y;
	static int[][] map;
	static int sol;
	
	// 벽을 세울 수 있는 모든 경우
	static void AllCase() {
		visited = new boolean[X][Y];
		
		for(int a = 0; a < X; a++) {
			for(int b = 0; b < Y; b++) {
				if(map[a][b] != 0) {
					continue;
				}
				
				map[a][b] = 1;
				
				for(int c = 0; c < X; c++) {
					for(int d = 0; d < Y; d++) {
						if(map[c][d] != 0 || (a == c && b == d) ) {
							continue;
						}
						
						map[c][d] = 1;
						
						for(int e = 0; e < X; e++) {
							for(int f = 0; f < Y; f++) {
								if(map[e][f] != 0 || (c == e && d == f) ) {
									continue;
								}
								
								map[e][f] = 1;
								
								diffusion();
								MaxChk();
								for(int i = 0; i < X; i++)
									for(int j = 0; j < Y; j++)
										if(map[i][j] == 2)
											q.add(new int[] {i, j});
								
								visited = new boolean[X][Y];
								
								map[e][f] = 0;
							}
						}
						
						map[c][d] = 0;
					}
				}
				
				map[a][b] = 0;
			}
		}
	}
	
	static Queue<int[]> q;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	// 벽을 세운후 세균을 퍼뜨림
	static void diffusion() {
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d = 0; d < dx.length; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];
				
				if(!inRange(nx ,ny) || map[nx][ny] != 0 || visited[nx][ny])
					continue;

				q.add(new int[] { nx, ny });
				visited[nx][ny] = true;
			}
		}
	}
	
	// 범위 검사
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < X && ny < Y;
	}
	
	// 안전영역 검사
	static void MaxChk() {
		int tmp = 0;
		for(int i = 0; i < X; i++) {
			for(int j = 0; j < Y; j++) {
				if(map[i][j] == 0 && !visited[i][j])
					tmp++;
			}
		}
		
		sol = (tmp > sol) ? tmp : sol;
	}
}