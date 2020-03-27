package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10800 {
	private static class Ball implements Comparable<Ball> {
		int id, color, size;

		public Ball(int id, int color, int size) {
			this.id = id;
			this.color = color;
			this.size = size;
		}

		@Override
		public int compareTo(Ball b) {
			return Integer.compare(size, b.size);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Ball[] balls = new Ball[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			balls[i] = new Ball(i + 1, color, size);
		}
		
		Arrays.sort(balls);
		
		int allSum = 0;
		int[] colors = new int[N + 1];
		int[] sol = new int[N + 1];
		
		for(int i = 0, j = 0; i < N; i++) {
			
			while(balls[j].size < balls[i].size) {
				allSum += balls[j].size;
				colors[balls[j].color] += balls[j].size;
				j++;
			}
			
			sol[balls[i].id] = allSum - colors[balls[i].color];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++)
			sb.append(sol[i] + "\n");
		
		System.out.print(sb.toString());
	}
}