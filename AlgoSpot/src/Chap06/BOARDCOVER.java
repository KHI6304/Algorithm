package Chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOARDCOVER {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int Row = Integer.parseInt(st.nextToken());
			int Col = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[Row][Col];
			int sum = 0;
			for(int i = 0; i < Row; i++) {
				char[] tmp = br.readLine().toCharArray();
				for(int j = 0; j < Col; j++) {
					if(tmp[j] == '.') {
						map[i][j] = 0;
						sum += 1;
					}
					else
						map[i][j] = -1;
				}
			}
			
			if( sum % 3 != 0 ) {
				System.out.println(0);
				continue;
			}
			
			
		}
	}
	
	static int[][][] coverType = {
			{ {0, 0}, {1, 0}, {0, 1} },
			{ {0, 0}, {0, 1}, {1, 1} },
			{ {0, 0}, {1, 0}, {1, 1} },
			{ {0, 0}, {1, 0}, {1, -1} }
	};
}