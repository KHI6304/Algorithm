package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		int[] tmp = new int[M];
		if(M != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++)
				tmp[i] = Integer.parseInt(st.nextToken());
		}
		
		size = 10 - M;
		arr = new int[size];
		
		int idx = 0;
		for(int i = 0; i < 10; i++) {
			boolean flag = true;
			for(int j = 0; j < M && flag; j++)
				if(i == tmp[j])
					flag = false;
			if(flag)
				arr[idx++] = i;
		}
		
		sol = Math.abs(N - 100);
		
		for(int i = 0; i < 6; i++)
			solve(i, 0, 0);
		
		System.out.println(sol);
	}
	
	private static int N;
	private static int M;
	private static int size;
	private static int sol;
	private static int[] arr;
	
	private static void solve(int digit, int depth, int num) {
		if(digit == 0) {
			for(int i = 0; i < arr.length; i++) {
				int clickCnt = Math.abs(N - arr[i]) + 1;
				sol = Math.min(sol, clickCnt);
			}
			return;
		}
		
		if(digit - depth < 0) {
			int clickCnt = Math.abs(N - num) + digit + 1;
			sol = Math.min(sol, clickCnt);
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(depth == 0 && arr[i] == 0)
				continue;
			int digitNum = (int) Math.pow(10, digit - depth) * arr[i];
			solve(digit, depth + 1, num + digitNum);
		}
	}
}