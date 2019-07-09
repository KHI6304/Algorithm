package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1946 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			Queue<String> queue = new LinkedList<>();
			int num = 0;
			
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				num = Integer.parseInt(st.nextToken());	
				for(int j = 0; j < num; j++)
					queue.add(s);
			}
			
			bw.write("#" + testCase + "\n");
			while(!queue.isEmpty()) {
				for(int i = 0; i < 10 && !queue.isEmpty(); i++)
					bw.write(queue.poll());
				bw.write("\n");
			}
		}
		bw.close();
	}
}