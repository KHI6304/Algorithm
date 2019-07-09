package Chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOGGLE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			map = new char[5][5];
			for(int i = 0; i < 5; i++)
				map[i] = br.readLine().toCharArray();
			
			int N = Integer.parseInt(br.readLine());
			
			for(int k = 0; k < N; k++) {
				String inp = br.readLine();
				boolean flag = false;
				for(int i = 0; i < 5 && !flag; i++) {
					for(int j = 0; j < 5 && !flag; j++) {
						flag = hasWord(i, j, inp);
					}
				}
				if(flag)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
	
	static char[][] map;
	static int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
	static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
	
	static boolean hasWord(int x, int y, String word) {
		if( !inRange(x, y) ) return false;
	
		if( map[x][y] != word.charAt(0) ) return false;
		
		if(word.length() == 1) return true;
		
		for(int dir = 0; dir < 8; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if( hasWord(nx, ny, word.substring(1)) )
				return true;
		}
		
		return false;
	}
	
	static boolean inRange(int x, int y) {
		return x >= 0 && y >= 0 && x < 5 && y < 5;
	}
}