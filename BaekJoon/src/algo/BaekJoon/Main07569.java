package algo.BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main07569 {
	static class Tomato {
		int h;
		int row;
		int col;
		int cnt;
		
		public Tomato(int h, int row, int col, int cnt) {
			this.h = h;
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken().trim());
		int N = Integer.parseInt(st.nextToken().trim());
		int H = Integer.parseInt(st.nextToken().trim());
		
		Queue<Tomato> queue = new LinkedList<>();
		int[][][] map = new int[H][N][M];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken().trim());
					if(map[i][j][k] == 1)
						queue.add(new Tomato(i, j, k, 0));
				}
			}
		}
		
		// 상, 하, 좌, 우
		int[] dh = {0, 0, 0, 0, 1, -1};
		int[] dx = {-1, 1, 0, 0, 0, 0};
		int[] dy = {0, 0, -1, 1, 0, 0};
		int cnt = 0;
		while (!queue.isEmpty()) {
			Tomato tmp = queue.poll();
			cnt = tmp.cnt;

			for (int i = 0; i < 6; i++) {
				int tmpRow = tmp.row + dx[i];
				int tmpCol = tmp.col + dy[i];
				int tmpH = tmp.h + dh[i];

				if (tmpRow >= N || tmpRow < 0 || tmpCol >= M || tmpCol < 0 || tmpH >= H || tmpH < 0)
					continue;

				if (map[tmpH][tmpRow][tmpCol] == 0) {
					queue.add(new Tomato(tmpH, tmpRow, tmpCol, tmp.cnt + 1));
					map[tmpH][tmpRow][tmpCol] = 1;
				}
			}
		}
		
		boolean flag = true;
		for(int i = 0; i < H && flag; i++)
			for(int j = 0; j < N && flag; j++)
				for(int k = 0; k < M && flag; k++)
					if(map[i][j][k] == 0)
						flag = false;
		
		if(flag)
			System.out.println(cnt);
		else
			System.out.println(-1);
	}
}