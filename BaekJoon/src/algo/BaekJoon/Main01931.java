package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main01931 {
	private static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end)
				return Integer.compare(this.start, o.start);
			return Integer.compare(this.end, o.end);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Meeting[] ms = new Meeting[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ms[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(ms);
		
		int sol = 1;
		int endTime = ms[0].end;
		for(int i = 1; i < N; i++) {
			if(ms[i].start >= endTime) {
				endTime = ms[i].end;
				sol++;
			}
		}
		
		System.out.println(sol);
	}
}