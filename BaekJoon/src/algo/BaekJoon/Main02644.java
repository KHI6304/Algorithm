package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] relationship = new boolean[n + 1][n + 1];
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			relationship[p1][p2] = relationship[p2][p1] = true;
		}
		
		boolean[] visited = new boolean[n + 1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a, 0});
		visited[a] = true;
		
		int ans = 0;
		while(!q.isEmpty() && !visited[b]) {
			int[] tmp = q.poll();
			
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && relationship[ tmp[0] ][i]) {
					q.add(new int[] {i, tmp[1] + 1});
					visited[i] = true;
					
					if(visited[b]) {
						ans = tmp[1] + 1;
						break;
					}
				}
			}
		}
		
		if(visited[b])
			System.out.println(ans);
		else
			System.out.println(-1);
	}
}