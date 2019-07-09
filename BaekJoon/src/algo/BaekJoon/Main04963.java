package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main04963 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			if(width == 0 && height == 0)
				break;
			
			int[][] map = new int[width][height];
			for(int i = 0; i < width; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < height; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			
		}
	}
}