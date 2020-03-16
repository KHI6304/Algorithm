package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int sol = 0;
		for(int i = K; i >= 0; i--) {
			if(W < i) continue;
			
			int W_tmp = W - i;
			int M_tmp = M - (K - i);
			
			if(M_tmp <= 0) continue;
			
			for(int j = M_tmp; j > 0; j--) {
				if(W_tmp / (j * 2) > 0) {
					sol = Math.max(sol, j);
					break;
				}
			}
		}
		
		System.out.println(sol);
	}
}