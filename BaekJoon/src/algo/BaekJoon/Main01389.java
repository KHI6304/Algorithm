package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01389 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // ������ ��
		int M = Integer.parseInt(st.nextToken()); // ģ�� ������ ��
		
		boolean[][] friends = new boolean[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friends[a][b] = friends[b][a] = true;
		}
		
		int[] ans = new int[N + 1]; // �ɺ� ������ �� ����
		
		// 1������ N�� ������ ����� �ɺ� ������ ���� ���
		for(int num = 1; num <= N; num++) {
			for(int i = 1; i <= N; i++) { // �ڱ� �ڽ��� ������ ��� ����� �ɺ� ������ �� ���
				if(num == i) continue;
				
				boolean[] visited = new boolean[N + 1];
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] {num, 0});
				
				boolean flag = true;
				while(!q.isEmpty() && flag) {
					for(int j = 1; j <= N; j++) {
						int[] tmp = q.poll();
						
						if(tmp[0] == i) {
							ans[num] += tmp[1];
							flag = false;
							break;
						}
						
						visited[ tmp[0] ] = true;
						
						for(int k = 1; k <= N; k++) {
							if(visited[k] || !friends[ tmp[0] ][k]) continue;
							
							q.add(new int[] {k, tmp[1] + 1});
						}
					}
				}
			}
		}
		
		int min_num = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++)
			min_num = Math.min(min_num, ans[i]);
		
		for(int i = 1; i <= N; i++) {
			if(ans[i] == min_num) {
				System.out.println(i);
				break;
			}
		}
	}
}