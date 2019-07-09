package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main07568 {
	static class People implements Comparable<People>{
		int w;
		int h;
		int idx;
		int rank;
		
		public People(int w, int h, int idx) {
			this.w = w;
			this.h = h;
			this.idx = idx;
			this.rank = 0;
		}
		
		@Override
		public int compareTo(People o) {
			if(w - o.w > 0 && h - o.h > 0 || w - o.w < 0 && h - o.h < 0)
				return w - o.w;
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		People[] ps = new People[N];
	
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ps[i] = new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
		}
		
		Arrays.sort(ps);
		
		int rank = 1;
		int cnt = 1;
		for(int i = N - 1; i > 0; i--) {
			if(ps[i].w > ps[i - 1].w && ps[i].h > ps[i - 1].h) {
				ps[i].rank = rank;
				rank += cnt;
				cnt = 1;
				ps[i - 1].rank = rank;
			}
			else {
				ps[i].rank = rank;
				cnt++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(ps[j].idx == i)
					System.out.print(ps[j].rank + " ");
			}
		}
	}
}