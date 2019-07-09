package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01352 {
	static class Computer {
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		cnt = new int[N + 1];
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			arr[B][A] = 1;
		}
		
		for(int i = 1; i <= N; i++)
			BFS(i, new boolean[N + 1]);
		
		
	}
	
	static int N;
	static int[][] arr;
	static int[] cnt;
	
	static void BFS(int n, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i = 1; i <= N; i++) {
				if(arr[tmp][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					cnt[n]++;
				}
			}
		}
	}
}