package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main01202 {
	private static class Gem implements Comparable<Gem> {
		int weight, value;

		public Gem(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(Gem g) {
			return Integer.compare(weight, g.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Gem[] gems = new Gem[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			gems[i] = new Gem(w, v);
		}
		
		int[] bags = new int[K];
		for(int i = 0; i < K; i++)
			bags[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(gems);
		Arrays.sort(bags);
		
		long sol = 0;
		int idx = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < K; i++) {
			while(idx < N && gems[idx].weight <= bags[i]) {
				pq.add(-gems[idx].value);
				idx++;
			}
			
			if(!pq.isEmpty())
				sol += -pq.poll();
		}
		
		System.out.println(sol);
	}
}