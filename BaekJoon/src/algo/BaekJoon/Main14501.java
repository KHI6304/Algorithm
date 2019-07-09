package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14501 {
	static class Counsel {
		int T;
		int P;
		
		public Counsel(int t, int p) {
			T = t;
			P = p;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Counsel[] cs = new Counsel[N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			cs[i] = new Counsel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		sol = 0;
		powerSet(cs, new boolean[N + 1], 1);
		System.out.println(sol);
	}
	
	static int sol;
	static void powerSet(Counsel[] cs, boolean[] sel, int idx) {
		if(cs.length == idx) {
			int sum = 0;
			for(int i = 1; i < cs.length; i++) {
				if(sel[i]) {
					if(i + cs[i].T > cs.length)
						return;
					
					for(int j = i + 1; j < i + cs[i].T; j++) {
						if(sel[j])
							return;
					}
					sum += cs[i].P;
				}
			}
			
			if(sum > sol)
				sol = sum;
			return;
		}
		
		sel[idx] = true;
		powerSet(cs, sel, idx + 1);
		sel[idx] = false;
		powerSet(cs, sel, idx + 1);
	}
}