package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17136 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[10][10];
		int[] used = new int[6];
		Arrays.fill(used, 5);
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		System.out.println(sol == Integer.MAX_VALUE ? -1 : sol);
	}
	
	static int sol = Integer.MAX_VALUE;
	
	static void deepCopy(int[][] src, int[][] copy) {
		for(int i = 0; i < src.length; i++)
			for(int j = 0; j < src[0].length; j++)
				copy[i][j] = src[i][j];
	}
	
	static boolean isComplete(int[][] map) {
		for(int i = 0; i < map.length; i++)
			for(int j = 0; j < map[0].length; j++)
				if(map[i][j] == 1)
					return false;
		return true;
	}
	
	static boolean inRange(int[][] map, int x, int y, int n) {
		if( x + n - 1 >= 10 || y + n - 1 >= 10 )
			return false;
		
		for(int r = x; r < x + n; r++) {
			for(int c = y; c < y + n; c++) {
				if(map[r][c] != 1)
					return false;
			}
		}
		
		return true;
	}
	
	static void solve(int[][] map, int[] used) {
		if( isComplete(map) ) {
			int sum = 0;
			for(int i = 1; i <= 5; i++)
				sum += used[i];
			sol = Math.min(sol, sum);
			return;
		}
		
		
		
	}
}















