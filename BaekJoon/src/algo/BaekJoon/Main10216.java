package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main10216 {
	static class Tower {
		int x;
		int y;
		int r;
		
		public Tower(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Tower[] ts = new Tower[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				ts[i] = new Tower(x, y, r);
			}
			
			parents = new int[N];
			rank = new int[N];
			for(int i = 0; i < N; i++)
				makeSet(i);
			
			for(int i = 0; i < N; i++) {
				for(int j = i; j < N; j++) {
					int a = (ts[i].x - ts[j].x) * (ts[i].x - ts[j].x) + (ts[i].y - ts[j].y) * (ts[i].y - ts[j].y);
					int b = (ts[i].r + ts[j].r) * (ts[i].r + ts[j].r);
					
					if(a <= b) {
						if( findSet(i) != findSet(j) )
							union(i, j);
					}
				}
			}
			
			Set<Integer> set = new HashSet<>();
			for(int i = 0; i < N; i++) {
				set.add(findSet(i));
			}
			
			System.out.println(set.size());
		}
	}
	
	static int[] parents;
	static int[] rank;
	
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if(parents[x] == x)
			return x;
		
		parents[x] = findSet(parents[x]);
		return parents[x];
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] > rank[py])
			parents[py] = px;
		else {
			parents[px] = py;
			if(rank[px] == rank[py])
				rank[py]++;
		}
	}
}