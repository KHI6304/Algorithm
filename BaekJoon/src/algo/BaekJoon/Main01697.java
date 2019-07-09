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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int sol = 0;
		
		boolean[] visited = new boolean[100001];
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {N, 0});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			if(tmp[0] == K) {
				sol = tmp[1];
				break;
			}
			
			if(!inRange(tmp[0]) || visited[ tmp[0] ])
				continue;
			
			visited[ tmp[0] ] = true;
			q.add(new int[] {tmp[0] + 1, tmp[1] + 1});
			q.add(new int[] {tmp[0] - 1, tmp[1] + 1});
			q.add(new int[] {tmp[0] * 2, tmp[1] + 1});
		}
		
		System.out.println(sol);
	}
	
	static boolean inRange(int np) {
		return np >= 0 && np <= 100000;
	}
}