package jungol.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		boolean[] visited;
		Set<Integer> set;
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			set = new HashSet<>();
			visited = new boolean[d + 1];
			int cnt = 0;
			
			for(int j = 0; j < k; j++) {
				int num = arr[(i + j) % N];
				if(visited[num])
					cnt++;
				if(min < cnt)
					break;
				visited[num] = true;
				set.add(num);
			}
			
			set.add(c);
			min = Math.min(min, cnt);
			max = Math.max(max, set.size());
		}
		
		System.out.println(max);
	}
}