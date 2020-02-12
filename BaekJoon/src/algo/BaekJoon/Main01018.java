package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		char[][] wMap = new char[8][8];
		char[][] bMap = new char[8][8];
		
		for(int i = 0; i < 8; i++) {
			if(i % 2 == 0) {
				wMap[i] = "WBWBWBWB".toCharArray();
				bMap[i] = "BWBWBWBW".toCharArray();
			}
			else {
				wMap[i] = "BWBWBWBW".toCharArray();
				bMap[i] = "WBWBWBWB".toCharArray();
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		for(int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		int sol = Integer.MAX_VALUE;
		
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0 ; j <= M - 8; j++) {
				int cnt = 0;
				for(int a = i; a < i + 8; a++) {
					for(int b = j; b < j + 8; b++) {
						if(map[a][b] != wMap[a - i][b - j])
							cnt++;
					}
				}
				sol = Math.min(sol, cnt);
				
				cnt = 0;
				for(int a = i; a < i + 8; a++) {
					for(int b = j; b < j + 8; b++) {
						if(map[a][b] != bMap[a - i][b - j])
							cnt++;
					}
				}
				sol = Math.min(sol, cnt);
			}
		}
		
		System.out.println(sol);
	}
}