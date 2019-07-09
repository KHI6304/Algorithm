package Chap18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class JOSEPHUS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());		
			LinkedList<Integer> list = new LinkedList<>();
			for(int i = 0; i < N; i++)
				list.add(i + 1);
			int idx = 0;
			
			while( list.size() != 2) {
				list.remove(idx);
				idx += K - 1;
				idx %= list.size();
			}
			
			for(int num : list)
				System.out.print(num + " ");
			System.out.println();
		}
	}
}