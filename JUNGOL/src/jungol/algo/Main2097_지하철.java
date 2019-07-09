package jungol.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2097_지하철 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N + 1][N + 1];
		int[][] path = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int mid = 1; mid <= N; mid++) {
			for(int start = 1; start <= N; start++) {
				for(int end = 1; end <= N; end++) {
					if(map[start][end] > map[start][mid] + map[mid][end]) {
						map[start][end] = map[start][mid] + map[mid][end];
						path[start][end] = mid;
					}
				}
			}
		}
		
		System.out.println(map[1][M]);
		
		list = new LinkedList<>();
		
		list.add(1);
		solve(path, 1, M);
		list.add(M);
		
		for(int i : list)
			System.out.print(i + " ");
	}
	
	static List<Integer> list; 
	static void solve(int[][] path, int start, int end) {
		if(path[start][end] == 0)
			return;
		
		solve(path, start, path[start][end]);
		list.add(path[start][end]);
		solve(path, path[start][end], end);
	}
}