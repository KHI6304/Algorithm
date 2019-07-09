package com.ssafy.algo;

import java.io.IOException;
import java.util.Scanner;

public class Solution4796 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			
			for(int j = 0; j < N; j++)
				arr[j] = sc.nextInt();
			
			sol = 0;
			for(i = 1; i < N; i++)
				solve(i);
			
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int N;
	static long sol;
	static int[] arr;
	static int i;
	
	static boolean inRange(int nx) {
		return nx >= 0 && nx < N;
	}
	
	static void solve(int idx) {
		long uptmp = 0;
		long downtmp = 0;
		
		int cnt = 1;
		while( inRange(idx + cnt) ) {
			if( arr[idx + cnt] < arr[idx + cnt - 1] ) {
				uptmp++;
				cnt++;
			}
			else
				break;
		}
		
		if(uptmp == 0)
			return;
		i += uptmp;
		
		cnt = 1;
		
		while( inRange(idx - cnt) ) {
			if( arr[idx - cnt] < arr[idx - cnt + 1] ) {
				downtmp++;
				cnt++;
			}
			else
				break;
		}
		
		if(uptmp > 0 && downtmp > 0)
			sol += uptmp * downtmp;
	}
}