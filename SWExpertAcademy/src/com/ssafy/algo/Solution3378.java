package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3378 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			String[] ps = new String[p];
			String[] qs = new String[q];
			
			for(int i = 0; i < p; i++)
				ps[i] = br.readLine();
			
			for(int i = 0; i < q; i++)
				qs[i] = br.readLine();
			
			bracketCnt = new int[6];
			pointCnt = new int[p];
			
			for(int i = 0; i < p; i++) {
				if(i != 0)
					solve(i);
				
				boolean Indent = true;
				for(int j = 0; j < ps[i].length(); j++) {
					while(ps[i].charAt(j) == '.' && Indent) {
						pointCnt[i]++;
						j++;
					}
					Indent = false;
					
					switch (ps[i].charAt(j)) {
					case '(':
						bracketCnt[0]++;
						break;
					case ')':
						bracketCnt[1]++;
						break;
					case '{':
						bracketCnt[2]++;
						break;
					case '}':
						bracketCnt[3]++;
						break;
					case '[':
						bracketCnt[4]++;
						break;
					case ']':
						bracketCnt[5]++;
						break;
					}
				}
			}
			
			bracketCnt = new int[6];
			System.out.print("#" + tc + " 0 ");
			for(int i = 0; i < q; i++) {
				int X = bracketCnt[0] - bracketCnt[1];
				int Y = bracketCnt[2] - bracketCnt[3];
				int Z = bracketCnt[4] - bracketCnt[5];
				int R = SolRCS[0];
				int C = SolRCS[1];
				int S = SolRCS[2];
				int sol = R * X + C * Y + Z * S;
				
				for(int j = 0; j < qs[i].length(); j++) {
					switch (qs[i].charAt(j)) {
					case '(':
						bracketCnt[0]++;
						break;
					case ')':
						bracketCnt[1]++;
						break;
					case '{':
						bracketCnt[2]++;
						break;
					case '}':
						bracketCnt[3]++;
						break;
					case '[':
						bracketCnt[4]++;
						break;
					case ']':
						bracketCnt[5]++;
						break;
					}
				}
				
				if(i == 0)
					continue;
				System.out.print(sol + " ");
			}
			System.out.println();
		}
	}
	
	static int[] bracketCnt;
	static int[] pointCnt;
	static int[] SolRCS;
	
	static void solve(int row) {
		int X = bracketCnt[0] - bracketCnt[1];
		int Y = bracketCnt[2] - bracketCnt[3];
		int Z = bracketCnt[4] - bracketCnt[5];
		int sol = pointCnt[row];
		if(sol == 0)
			return;
	
		for(int R = 1; R <= 20; R++) {
			for(int C = 1; C <= 20; C++) {
				for(int S = 1; S <= 20; S++) {
					int tmp = R * X + C * Y + S * Z;
					if(tmp == sol)
						System.out.println(R + " " + C + " " + S);
				}
			}
		}
	}
}






















