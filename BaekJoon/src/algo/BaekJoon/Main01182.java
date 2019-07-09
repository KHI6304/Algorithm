package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01182 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		
		sol = 0;
		powerSet(arr, new boolean[N], 0);
		System.out.println(sol);
	}
	
	static int sol;
	static int S;
	static void powerSet(int[] arr, boolean[] sel, int idx) {
		if(arr.length == idx) {
			int sum = 0;
			int cnt = 0;
			for(int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					sum += arr[i];
					cnt++;
				}
			}
			
			if(cnt == 0)
				return;
			
			if(sum == S)
				sol++;
			return;
		}
		
		sel[idx] = true;
		powerSet(arr, sel, idx + 1);
		sel[idx] = false;
		powerSet(arr, sel, idx + 1);
	}
}