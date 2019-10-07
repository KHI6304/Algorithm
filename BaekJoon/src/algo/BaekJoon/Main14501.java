package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		sol = Integer.MIN_VALUE;
		
		solve(0, 0);
		System.out.println(sol);
	}
	
	private static int N;
	private static int[] T;
	private static int[] P;
	private static int sol;
	
	private static void solve(int idx, int profit) {
		if(idx >= N) {
			sol = Math.max(sol, profit);
			return;
		}
		
		if(idx + T[idx] <= N)
			solve(idx + T[idx], profit + P[idx]);
		
		solve(idx + 1, profit);
	}
}