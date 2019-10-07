package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14391 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int Row = Integer.parseInt(st.nextToken());
		int Col = Integer.parseInt(st.nextToken());
		int[][] map = new int[Row][Col];
		for(int i = 0; i < Row; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j < Col; j++)
				map[i][j] = tmp[j] - 0;
		}
		
		
	}
}