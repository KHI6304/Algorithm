package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17281 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][9];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] order = new int[9];
		for(int i = 0; i < order.length; i++)
			order[i] = i + 1;
		order[3] = 1;
		order[0] = 4;
		
		sol = 0;
		perm(order, 0);
		System.out.println(sol);
	}
	
	static int N;
	static int[][] map;
	static int sol;
	
	static void perm(int[] arr, int idx) {
		if(idx == 3) {
			perm(arr, idx + 1);
			return;
		}
		
		if(arr.length == idx) {
			int score = 0;
			int order = 0;
			
			for(int i = 0; i < N; i++) {
				int outCnt = 0;
				Queue<Integer> q = new LinkedList<>();
				
				while(outCnt != 3) {
					order %= 9;
					
					int res = map[i][ arr[order++] - 1 ];
					switch(res) {
					case 0:
						outCnt++;
						break;
					case 1:
						q.add(1);
						break;
					case 2:
						q.add(1);
						q.add(0);
						break;
					case 3:
						q.add(1);
						q.add(0);
						q.add(0);
						break;
					case 4:
						q.add(1);
						q.add(0);
						q.add(0);
						q.add(0);
						break;
					}
					
					while(q.size() > 3) {
						int cnt = q.poll();
						if(cnt == 1)
							score++;
					}
				}
				
			}
			
			if(sol < score)
				sol = score;
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			swap(arr, idx, i);
			perm(arr, idx + 1);
			swap(arr, idx, i);
		}
	}
	
	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}