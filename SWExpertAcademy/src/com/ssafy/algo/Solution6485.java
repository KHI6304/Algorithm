package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6485 {
	static class Bus {
		int start;
		int dest;
		
		public Bus(int start, int dest) {
			this.start = start;
			this.dest = dest;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Bus[] bs = new Bus[N];
			for(int i = 0; i < bs.length; i++) {
				st = new StringTokenizer(br.readLine());
				bs[i] = new Bus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			int[] busStop = new int[5001];
			for(int i = 0; i < N; i++)
				for(int start = bs[i].start; start <= bs[i].dest; start++)
					busStop[start]++;
			
			int P = Integer.parseInt(br.readLine());
			int[] C = new int[P];
			for(int i = 0; i < C.length; i++)
				C[i] = Integer.parseInt(br.readLine());
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < C.length; i++)
				System.out.print(busStop[C[i]] + " ");
			System.out.println();
		}
	}
}