package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		comb(arr, new int[3], 0, 0);
		
		System.out.println(ans);
	}
	
	private static int M;
	private static int ans;
	
	private static void comb(int[] arr, int[] sel, int idx, int cnt) {
		if(cnt == sel.length) {
			int sum = 0;
			for(int i = 0; i < sel.length; i++)
				sum += sel[i];
			
			if(sum > M)
				return;
			
			ans = Math.max(ans, sum);
			
			return;
		}
		if(idx == arr.length)
			return;
		
		sel[cnt] = arr[idx];
		comb(arr, sel, idx + 1, cnt + 1);
		comb(arr, sel, idx + 1, cnt);
	}
}