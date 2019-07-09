package Chap19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JOSEPHUS_QUEUE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());		
			Queue<Integer> q = new LinkedList<>();
			for(int i = 0; i < N; i++)
				q.add(i + 1);
			
			while( q.size() != 2 ) {
				q.poll();
				for(int i = 0; i < K - 1; i++)
					q.add(q.poll());
			}
			
			int n1 = q.poll(), n2 = q.poll();
			System.out.println(n1 > n2 ? n2 + " " + n1 : n1 + " " + n2);
		}
	}
}