package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main02775 {
	/*
	 * 재귀로 푸는 방법과 이차원 배열에다가 값을 저장하는 단순 반복으로 푸는 방법이 있다.
	 * 코드의 간결함은 재귀로 푸는 것이 월등히 좋지만,
	 * 속도면에서는 후자와 5배 정도 차이가 난다.
	 * 이를 통해 재귀는 속도 면에서 많은 손해가 생긴다는 것을 알 수 있었다.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			
			System.out.println(solve(k, n));
		}
	}
	
	private static int solve(int k, int n) {
		if(n == 0)
			return 0;
		else if(k == 0)
			return n;
		else
			return solve(k, n - 1) + solve(k - 1, n);
	}
}