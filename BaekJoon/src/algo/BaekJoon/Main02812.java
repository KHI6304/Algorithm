package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main02812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String num = br.readLine();
		Stack<Integer> s = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			int n = num.charAt(i) - '0';
			
			while(K > 0 && !s.isEmpty() && s.peek() < n) {
				s.pop();
				K--;
			}
			s.push(n);
		}
		
		while(K > 0) {
			s.pop();
			K--;
		}
		
		StringBuilder sb = new StringBuilder();
		while(!s.isEmpty())
			sb.append(s.pop());
		
		System.out.println(sb.reverse().toString());
	}
}