package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main10165 {
	private static class Bus implements Comparable<Bus> {
		int num, start, end;

		public Bus(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Bus b) {
			if(start == b.start) return -Integer.compare(end, b.end);
			return Integer.compare(start, b.start);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int maxEnd = -1;
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(start > end) {
				pq.add(new Bus(i + 1, start, end + N));
				maxEnd = Math.max(maxEnd, end);
			}
			else
				pq.add(new Bus(i + 1, start, end));
		}
		
		int end = -1;
		boolean[] numbers = new boolean[M + 1];
		while(!pq.isEmpty()) {
			Bus b = pq.poll();
			
			if(b.end <= maxEnd)
				numbers[b.num] = true;
			else if(b.end <= end)
				numbers[b.num] = true;
			else
				end = b.end;
		}
		
		for(int i = 1; i <= M; i++)
			if(!numbers[i]) System.out.print(i + " ");
	}
}