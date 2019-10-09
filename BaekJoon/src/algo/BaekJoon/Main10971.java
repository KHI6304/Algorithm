package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10971 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				W[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = i;
		
		sol = Integer.MAX_VALUE;
		perm(arr, 0);
		
		System.out.println(sol);
	}
	
	private static int N;
	private static int[][] W;
	private static int sol;
	
	private static void perm(int[] arr, int idx) {
		if(idx == arr.length) {
			int sum = 0;
			
			int index = 0;
			while(index != arr.length - 1) {
				int cost = W[ arr[index] ][ arr[index + 1] ];
				if(cost == 0)
					return;
				
				sum += cost;
				index++;
			}
			
			if( W[ arr[index] ][ arr[0] ] == 0 )
				return;
			
			sum += W[ arr[index] ][ arr[0] ];
			sol = Math.min(sol, sum);
			
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			swap(arr, idx, i);
			perm(arr, idx + 1);
			swap(arr, idx, i);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}