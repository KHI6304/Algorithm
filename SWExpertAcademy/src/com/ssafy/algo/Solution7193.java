package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution7193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String X = st.nextToken();
			
			int sol = 0;
			int sum = 0;
			for(int i = 0; i < X.length(); i++)
				sum += (X.charAt(i) - '0') % (N - 1);
			sol = sum % (N - 1);
			sb.append("#").append(tc).append(" ").append(sol).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
}