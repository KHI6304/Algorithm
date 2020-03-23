package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		last = new int[N];
		
		int sol = 0;
		int solIdx = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			last[i] = -1;
			
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
					last[i] = j;
				}
			}
			
			if(sol < dp[i]) {
				sol = dp[i];
				solIdx = i;
			}
		}
		
		System.out.println(sol);
		System.out.println(print(solIdx).trim());
	}
	
	private static int[] arr;
	private static int[] dp;
	private static int[] last;
	
	private static String print(int idx) {
		if(idx == -1)
			return "";
		
		return print(last[idx]) + " " + arr[idx];
	}
}