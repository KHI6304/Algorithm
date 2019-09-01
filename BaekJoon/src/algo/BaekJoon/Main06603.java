package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main06603 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			if(k == 0) break;
			
			int[] arr = new int[k];
			for(int i = 0; i < k; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			comb(arr, new int[6], 0, 0);
			System.out.println();
		}
	}
	
	private static void comb(int[] arr, int[] sel, int idx, int cnt) {
		if(cnt == sel.length) {
			for(int i = 0; i < sel.length; i++)
				System.out.print(sel[i] + " ");
			System.out.println();
			return;
		}
		
		if(idx == arr.length)
			return;
		
		sel[cnt] = arr[idx];
		comb(arr, sel, idx + 1, cnt + 1);
		comb(arr, sel, idx + 1, cnt);
	}
}