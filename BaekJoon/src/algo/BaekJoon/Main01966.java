package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<>();
			List<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				q.add(num);
				list.add(num);
			}
			
			Collections.sort(list);
			Collections.reverse(list);
			
			int sol = 0;
			while(!q.isEmpty()) {
				if(q.peek() == list.get(0)) {
					q.poll();
					sol++;
					list.remove(list.get(0));
					
					if(M == 0)
						break;
					M--;
				}
				else {
					if(M == 0)
						M += q.size() - 1;
					else
						M--;
					
					int tmp = q.poll();
					q.add(tmp);
				}
			}
			
			System.out.println(sol);
		}
	}
}