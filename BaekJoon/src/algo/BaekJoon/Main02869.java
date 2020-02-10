package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02869 {
	/*
	 * 반복문을 쓰면 무조건 시간초과가 뜬다.
	 * 그래서 수학적인 계산으로 풀 수 밖에 업다.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int day = (int) Math.ceil( (double) (V - A) / (double) (A - B) ) + 1;
		
		System.out.println(day);
	}
}