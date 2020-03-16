package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main01946 {
	private static class Node implements Comparable<Node> {
		int gradeA, gradeB;

		public Node(int gradeA, int gradeB) {
			this.gradeA = gradeA;
			this.gradeB = gradeB;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.gradeA, o.gradeA);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Node[] inps = new Node[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int gradeA = Integer.parseInt(st.nextToken());
				int gradeB = Integer.parseInt(st.nextToken());
				
				inps[i] = new Node(gradeA, gradeB);
			}
			
			Arrays.sort(inps);
			
			int sol = N;
			
			int max = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				if(max > inps[i].gradeB)
					max = inps[i].gradeB;
				else
					sol--;
			}
			
			System.out.println(sol);
		}
	}
}