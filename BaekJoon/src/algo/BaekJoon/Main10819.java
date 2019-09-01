package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10819 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		perm(arr, 0);
		
		System.out.println(sol);
	}
	
	private static int sol = 0;
	
	private static void perm(int[] arr, int idx) {
		if(idx == arr.length) {
			int sum = 0;
			
			for(int i = 0; i < arr.length - 1; i++)
				sum += Math.abs(arr[i] - arr[i + 1]);
			
			sol = Math.max(sol, sum);
			
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