package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03020 {
	private static int stoi(String s) { return Integer.parseInt(s); }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] bot = new int[H + 1];
		int[] top = new int[H + 1];
		
		for(int i = 0; i < N / 2; i++) {
			bot[stoi(br.readLine())]++;
			top[stoi(br.readLine())]++;
		}
		
		int[] botSum = new int[H + 1];
		int[] topSum = new int[H + 1];
		
		for(int h = 1; h <= H; h++) {
			botSum[h] = botSum[h - 1] + bot[h];
			topSum[h] = topSum[h - 1] + top[h];
		}
		
		int sol = N;
		int solCnt = 0;
		for(int h = 1; h <= H; h++) {
			int cnt = 0;
			
			cnt += botSum[H] - botSum[h - 1];
			cnt += topSum[H] - topSum[H - h];
			
			if(cnt < sol) {
				sol = cnt;
				solCnt = 1;
			}
			else if(cnt == sol)
				solCnt++;
		}
		
		System.out.println(sol + " " + solCnt);
	}
}