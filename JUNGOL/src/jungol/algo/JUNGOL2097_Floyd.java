package jungol.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL2097_Floyd {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		path = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						path[i][j] = k;
					}
				}
			}
		}
		
		System.out.println(map[1][M]);
		if(path[1][M] != 0) {
			System.out.print("1 ");
			recur(1, M, 0);
			System.out.println(M);
		}
		else
			System.out.println("1 " + M);
	}
	
	static int[][] map;
	static int[][] path;
	static void recur(int start, int dest, int cnt) {
		int mid = path[start][dest];
		if(mid == 0)
			return;
		
		recur(start, mid, cnt + 1);
		System.out.print(mid + " ");
		recur(mid, dest, cnt + 1);
	}
}