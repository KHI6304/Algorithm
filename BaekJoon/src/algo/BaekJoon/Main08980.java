package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main08980 {
	private static class Box implements Comparable<Box> {
		int start, end, cnt;

		public Box(int start, int end, int cnt) {
			this.start = start;
			this.end = end;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Box o) {
			if(end == o.end) return -Integer.compare(start, o.start);
			return Integer.compare(end, o.end);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] city = new int[N + 1];
		
		int M = Integer.parseInt(br.readLine());
		Box[] boxes = new Box[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			boxes[i] = new Box(start, end, cnt);
		}
		
		Arrays.sort(boxes);
		
		int sol = 0;
		for(int i = 0; i < M; i++) {
			int start = boxes[i].start;
			int end = boxes[i].end;
			int cnt = boxes[i].cnt;
			
			int plusCnt = Integer.MAX_VALUE;
			for(int j = start; j < end; j++) {
				if(city[j] == C) {
					plusCnt = 0;
					break;
				}
				
				if(city[j] + cnt > C) {
					plusCnt = Math.min(plusCnt, C - city[j]);
				}
				else if(city[j] + cnt <= C) {
					plusCnt = Math.min(plusCnt, cnt);
				}
			}
			
			for(int j = start; j < end; j++)
				city[j] += plusCnt;
			sol += plusCnt;
		}
		
		System.out.println(sol);
	}
}