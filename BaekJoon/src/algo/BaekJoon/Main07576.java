package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main07576 {
	static class Tomato {
		int row;
		int col;
		int cnt;
		
		public Tomato(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
	// 상, 하, 좌, 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		Queue<Tomato> queue = new LinkedList<>();
		int[][] box = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1)
					queue.add(new Tomato(i, j, 0));
			}
		}
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			Tomato tmp = queue.poll();
			cnt = tmp.cnt;
			
			for(int i = 0; i < 4; i++) {
				int tmpRow = tmp.row + dx[i];
				int tmpCol = tmp.col + dy[i];
				
				if(tmpRow >= box.length || tmpRow < 0 || tmpCol >= box[tmpRow].length || tmpCol < 0)
					continue;
				
				if(box[tmpRow][tmpCol] == 0) {
					queue.add(new Tomato(tmpRow, tmpCol, tmp.cnt + 1));
					box[tmpRow][tmpCol] = 1;
				}
			}
		}
		
		boolean flag = true;
		for(int i = 0; i < box.length; i++)
			for(int j = 0; j < box[i].length; j++)
				if(box[i][j] == 0)
					flag = false;
		
		if(flag)
			System.out.println(cnt);
		else
			System.out.println(-1);
	}
}