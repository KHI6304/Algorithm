package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			P[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(P);
		
		int sol = 0;
		for(int i = 0; i < N; i++)
			sol += P[i] * (N - i);
		
		System.out.println(sol);
	}
}