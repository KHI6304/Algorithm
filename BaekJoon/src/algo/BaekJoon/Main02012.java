package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main02012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] inp = new int[N];
		for(int i = 0; i < N; i++)
			inp[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(inp);
		
		long sol = 0;
		for(int i = 1; i <= N; i++)
			sol += Math.abs(inp[i - 1] - i);
		
		System.out.println(sol);
	}
}