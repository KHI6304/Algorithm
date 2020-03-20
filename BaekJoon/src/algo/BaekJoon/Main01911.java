package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main01911 {
	private static class Pool implements Comparable<Pool> {
		int start, end;

		public Pool(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pool o) {
			return Integer.compare(start, o.start);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // ¹°¿õµ¢ÀÌ °³¼ö
		int L = Integer.parseInt(st.nextToken()); // ³ÎºþÁö ±æÀÌ
		
		Pool[] pools = new Pool[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			pools[i] = new Pool(start, end);
		}
		
		Arrays.sort(pools);
		
		int sol = 0;
		
		int end = -1;
		for(int i = 0; i < N; i++) {
			int start = pools[i].start;
			if(start < end)
				start = end;
			
			int dist = pools[i].end - start;
			
			int cnt = (int) Math.ceil(dist / (double) L);
			sol += cnt;
			end = start + cnt * L;
		}
		
		System.out.println(sol);
	}
}