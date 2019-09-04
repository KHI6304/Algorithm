package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		sol = 0;
		
		BFS();
		System.out.println(sol);
	}
	
	private static int N;
	private static int K;
	private static boolean[] visited;
	private static int sol;
	
	private static boolean inRange(int n) {
		return n >= 0 && n <= 100000;
	}
	
	private static void BFS() {
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(N, 0));
		
		boolean flag = true;
		while(!q.isEmpty() && flag) {
			Position pos = q.poll();
			
			for(int i = 0; i < 3 && flag; i++) {
				int np = pos.p;
				
				if(np == K) {
					sol = pos.sec;
					flag = false;
					break;
				}
				
				switch(i) {
				case 0 :
					np += 1;	
					break;
				case 1 :
					np -= 1;	
					break;
				case 2 :
					np *= 2;	
					break;
				}
				
				if(!inRange(np))
					continue;
				
				if(!visited[np]) {
					visited[np] = true;
					q.add(new Position(np, pos.sec + 1));
				}
			}
		}
	}
	
	private static class Position {
		int p;
		int sec;
		public Position(int p, int sec) {
			this.p = p;
			this.sec = sec;
		}
	}
}