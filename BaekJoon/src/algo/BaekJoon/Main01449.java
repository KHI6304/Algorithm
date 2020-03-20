package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main01449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken()) - 1;
		
		int[] inp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			inp[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(inp);
		
		int sol = 0;
		int start = -100000;
		for(int i = 0; i < inp.length; i++) {
			// 테이프의 시작점에서 현재 지점 까지의 거리가 테이프의 길이가 넘어갔을때 실행되는 조건입니다.
			if(inp[i] - start > L) {
				start = inp[i];
				sol++;
			}
		}
		
		System.out.println(sol);
	}
}