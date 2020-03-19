package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18185 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] inp = new int[N + 2];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			inp[i] = Integer.parseInt(st.nextToken());
		
		int sol = 0;
		for(int i = 0; i < N; i++) {
			if(inp[i + 1] > inp[i + 2]) {
				int buyTwo = Math.min(inp[i], inp[i + 1] - inp[i + 2]);
				for(int j = 0; j < 2; j++)
					inp[i + j] -= buyTwo;
				sol += buyTwo * 5;
				
				int buyThree = Math.min(inp[i], Math.min(inp[i + 1], inp[i + 2]));
				for(int j = 0; j < 3; j++)
					inp[i + j] -= buyThree;
				sol += buyThree * 7;
			}
			else {
				int buyThree = Math.min(inp[i], Math.min(inp[i + 1], inp[i + 2]));
				for(int j = 0; j < 3; j++)
					inp[i + j] -= buyThree;
				sol += buyThree * 7;
				
				int buyTwo = Math.min(inp[i], inp[i + 1]);
				for(int j = 0; j < 2; j++)
					inp[i + j] -= buyTwo;
				sol += buyTwo * 5;
			}
			
			sol += inp[i] * 3;
		}
		
		System.out.println(sol);
	}
}