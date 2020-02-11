package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01011 {
	/*
	 * 처음에는 재귀로 풀려고 시도 해봤지만
	 * 메모리 부족으로 런타임 에러가 떴다.
	 * 그래서 규칙을 찾은 후,
	 * 수학적으로 푸는 방법을 사용했다.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dis = y - x;
			int ans = 0;
			
			int n = 1;
			while(true) {
				int nSquare = (int) Math.pow(n, 2);
				
				if(dis >= nSquare - n + 1 && dis <= nSquare) {
					ans = n * 2 -1;
					break;
				}
				
				if(dis <= nSquare + n) {
					ans = n * 2;
					break;
				}
				
				n++;
			}
			
			System.out.println(ans);
		}
	}
}