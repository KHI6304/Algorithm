package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main12018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()); // ��û�� ��� ��
			int L = Integer.parseInt(st.nextToken()); // ���� �ο�
			
			st = new StringTokenizer(br.readLine());
			int[] inp = new int[P];
			for(int j = 0; j < inp.length; j++)
				inp[j] = -Integer.parseInt(st.nextToken()); // ������������ ������ ���ؼ� -�� ���� ���� �ִ´�.
			
			Arrays.sort(inp);
			
			if(P < L)
				pq.add(1);
			else
				pq.add(-inp[L - 1]);
		}
		
		int cnt = 0;
		int sum = 0;
		while(!pq.isEmpty()) {
			sum += pq.poll();
			
			if(sum > m) break;
			
			cnt++;
		}
		
		System.out.println(cnt);
	}
}