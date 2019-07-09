package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main10451 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N + 1];
			boolean[] visited = new boolean[N + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int sol = 0;
			for(int i = 1; i <= N; i++) {
				if(!visited[i]) {
					BFS(i, visited, arr);
					sol++;
				}
			}
			
			System.out.println(sol);
		}
	}
	
	static void BFS(int num, boolean[] visited, int[] arr) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(num);
		visited[num] = true;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			int val = arr[tmp];
			
			if(!visited[val]) {
				q.add(val);
				visited[val] = true;
			}
		}
	}
}