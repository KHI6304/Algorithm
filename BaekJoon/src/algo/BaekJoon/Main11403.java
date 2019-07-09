package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] visited = new int[N][N];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			q.add(i);
			while(!q.isEmpty()) {
				int tmp = q.poll();
				for(int j = 0; j < N; j++) {
					if(map[tmp][j] == 1 && visited[i][j] == 0) {
						visited[i][j] = 1;
						q.add(j);
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				System.out.print(visited[i][j] + " ");
			System.out.println();
		}
	}
}