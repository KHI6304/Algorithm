package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		A = st.nextToken().toCharArray();
		B = st.nextToken().toCharArray();
		
		sol = Integer.MAX_VALUE;
		solve();
		System.out.println(sol);
	}
	
	private static char[] A, B;
	private static int sol;
	
	private static void solve() {
		for(int i = 0; i <= B.length - A.length; i++) {
			int cnt = 0;
			
			for(int idx = 0; idx < A.length; idx++)
				if(A[idx] != B[idx + i]) cnt++;
			
			sol = Math.min(sol, cnt);
		}
	}
}