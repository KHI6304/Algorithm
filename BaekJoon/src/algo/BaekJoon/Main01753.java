package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01753 {
	static final int INF = 9999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		int[][] map = new int[V + 1][V + 1];
		for(int i = 1; i <= V; i++)
			for(int j = 1; j <= V; j++)
				map[i][j] = INF;
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(map[a][b] > num)
				map[a][b] = num;
		}
		
		for(int m = 1; m <= V; m++) {
			for(int s = 1; s <= V; s++) {
				for(int e = 1; e <= V; e++) {
					if(map[s][e] > map[s][m] + map[m][e])
						map[s][e] = map[s][m] + map[m][e];
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(i == K)
				System.out.println(0);
			else {
				System.out.println(map[K][i] == INF ? "INF" : map[K][i]);
			}
		}
	}
}