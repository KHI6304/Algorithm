package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		for(int i = 0; i < N; i++)
			coins[i] = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for(int i = N - 1; i >= 0; i--) {
			if(coins[i] > K) continue;
			if(K == 0) break;
			
			int tmp = 1;
			while(true) {
				if(coins[i] * (tmp + 1) > K) break;
				
				tmp++;
			}
			
			K -= coins[i] * tmp;
			cnt += tmp;
		}
		
		System.out.println(cnt);
	}
	
}