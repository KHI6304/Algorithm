package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int[][] cpy = new int[N][M];
			mapCpy(map, cpy);
			
			for(int j = 0; j < s; j++) {
				int sr = r - s + j - 1;
				int sc = c - s + j - 1;
				
				int lr = r + s - j - 1;
				int lc = r + s - j - 1;
				
				for(int col = sc + 1; col <= lc; col++)
					cpy[sr][col] = map[sr][col - 1];
				
				for(int row = sr + 1; row <= lr; row++)
					cpy[row][lc] = map[row - 1][lc];
				
				for(int col = lc - 1; col >= sc; col--)
					cpy[lr][col] = map[lr][col + 1];
				
				for(int row = sr - 1; row >= sr; row--)
					cpy[row][sc] = map[row + 1][sc];
			}
			mapCpy(cpy, map);
			
			System.out.println();
			for(int a = 0; a < N; a++) {
				for(int j = 0; j < M; j++)
					System.out.print(map[a][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
	
	private static void mapCpy(int[][] src, int[][] cpy) {
		for(int i = 0; i < src.length; i++)
			for(int j = 0; j < src[0].length; j++)
				cpy[i][j] = src[i][j];
	}
}