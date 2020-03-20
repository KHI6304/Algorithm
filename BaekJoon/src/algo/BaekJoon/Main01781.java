package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main01781 {
	private static class Problem implements Comparable<Problem> {
		int deadline, cnt;	// 데드라인, 컵라면 수

		public Problem(int deadline, int cnt) {
			this.deadline = deadline;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Problem p) {
			return Integer.compare(deadline, p.deadline);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Problem[] ps = new Problem[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int deadline = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			ps[i] = new Problem(deadline, cnt);
		}
		
		Arrays.sort(ps);
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int sol = 0;
		for(int i = 0; i < N; i++) {
			q.add(ps[i].cnt);
			while(ps[i].deadline < q.size())
				q.poll();
		}
		
		while(!q.isEmpty())
			sol += q.poll();
		
		System.out.println(sol);
	}
}