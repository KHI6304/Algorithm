package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main03190 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 보드 크기
		int[][] map = new int[N + 1][N + 1];
		int K = Integer.parseInt(br.readLine());	// 사과 개수
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			// 사과는 10으로
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 100;
		}
		map[1][1] = -100;
		
		int[] head = {1, 1};
		int[] tail = {1, 1};
		int L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			
			for(int j = 0; j < second; j++) {
				
			}
		}
	}
}



























