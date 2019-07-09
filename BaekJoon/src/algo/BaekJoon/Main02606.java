package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N + 1][N + 1];
		boolean[] visited = new boolean[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		int sol = 0;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && map[tmp][i] == 1) {
					q.add(i);
					visited[i] = true;
					sol++;
				}
			}
		}
		
		System.out.println(sol);
	}
}