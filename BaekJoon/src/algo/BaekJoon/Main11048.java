package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11048 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
        int[][] map = new int[row][col];
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++)
            	map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[row + 1][col + 1];
        dp[1][1] = map[0][0];
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i-1][j-1];
            }
        }
        
        System.out.println(dp[row][col]);
	}
}