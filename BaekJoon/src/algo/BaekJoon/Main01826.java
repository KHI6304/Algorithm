package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main01826 {
	private static class GasStation implements Comparable<GasStation> {
		int pos, gas;

		public GasStation(int pos, int gas) {
			this.pos = pos;
			this.gas = gas;
		}

		@Override
		public int compareTo(GasStation gs) {
			return Integer.compare(pos, gs.pos);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		GasStation[] gs = new GasStation[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken());
			int gas = Integer.parseInt(st.nextToken());
			
			gs[i] = new GasStation(pos, gas);
		}
		
		Arrays.sort(gs);
		
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken()); // 마을의 위치
		int P = Integer.parseInt(st.nextToken()); // 연료의 양
		
		int sol = 0;
		int idx = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while(P < L) {
			while(idx < N && gs[idx].pos <= P) {
				pq.add(-gs[idx].gas);
				idx++;
			}
			
			if(!pq.isEmpty()) {
				sol++;
				P += -pq.poll();
			}
			else break;
		}
		
		System.out.println(P < L ? -1 : sol);
	}
}