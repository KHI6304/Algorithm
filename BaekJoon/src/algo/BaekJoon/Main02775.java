package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main02775 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] apart = new int[k + 1][n + 1];
			for(int i = 1; i <= n; i++)
				apart[0][i] = i;
			
			for(int i = 1; i <= k; i++) {
				for(int j = 1; j <= n; j++) {
					for(int a = 1; a <= j; a++) {
						apart[i][j] += apart[i - 1][a];
					}
				}
			}
			
			System.out.println(apart[k][n]);
		}
	}
}