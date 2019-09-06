package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main09019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			visited = new boolean[30000];
			
			BFS();
		}
	}
	
	private static int A;
	private static int B;
	private static boolean[] visited;
	
	private static class Position {
		int n;
		String s;
		
		public Position(int n, String s) {
			this.n = n;
			this.s = s;
		}
	}
	
	private static void BFS() {
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(A, ""));
		visited[A] = true;
		boolean flag = true;
		while(!q.isEmpty() && flag) {
			Position p = q.poll();
			
			for(int i = 0; i < 4 && flag; i++) {
				int np = 0;
				String ns = null;
				
				if( i == 0 ) {
					np = 2 * p.n;
					
					if(visited[np])
						continue;
					
					ns = p.s.concat("D");
					if(np > 9999)
						np %= 10000;
					
					if(np == B) {
						flag = false;
						System.out.println(ns);
					}
					visited[np] = true;
					q.add(new Position(np, ns));
				}
				else if( i == 1 ) {
					np = p.n - 1;
					
					if(np == -1)
						np = 9999;
					
					if(visited[np])
						continue;
					
					ns = p.s.concat("S");
					
					if(np == B) {
						flag = false;
						System.out.println(ns);
					}
					visited[np] = true;
					q.add(new Position(np, ns));
				}
				else if( i == 2 ) {
					int[] arr = new int[4];
					for(int j = 0; j < 4; j++)
						arr[j] = (p.n / (int) Math.pow(10, j)) % 10;
					np = arr[2] * 1000 + arr[1] * 100 + arr[0] * 10 + arr[3];
					
					if(visited[np])
						continue;
					
					ns = p.s.concat("L");
					
					if(np == B) {
						flag = false;
						System.out.println(ns);
					}
					visited[np] = true;
					q.add(new Position(np, ns));
				}
				else if( i == 3 ) {
					int[] arr = new int[4];
					for(int j = 0; j < 4; j++)
						arr[j] = (p.n / (int) Math.pow(10, j)) % 10;
					np = arr[0] * 1000 + arr[3] * 100 + arr[2] * 10 + arr[1];
					
					if(visited[np])
						continue;
					
					ns = p.s.concat("R");
					
					if(np == B) {
						flag = false;
						System.out.println(ns);
					}
					visited[np] = true;
					q.add(new Position(np, ns));
				}
			}
		}
	}
}
