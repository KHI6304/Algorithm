package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		maxLen = 0;
		lans = new int[K];
		for(int i = 0; i < K; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			maxLen = Math.max(maxLen, lans[i]);
		}
		
		System.out.println(search());
	}
	
	private static int K, N;
	private static int maxLen;
	private static int[] lans;
	
	private static long search() {
		long low = 1;
		long high = maxLen;
		
		long sol = 0;
		while(low <= high) {
			long mid = (low + high) / 2;
			
			if(solve(mid)) {
				sol = Math.max(sol, mid);
				low = mid + 1;
			}
			else
				high = mid - 1;
		}
		
		return sol;
	}
	
	private static boolean solve(long len) {
		int cnt = 0;
		
		for(int i = 0; i < K; i++) {
			cnt += lans[i] / len;
			if(cnt >= N) return true;
		}
		
		return false;
	}
}