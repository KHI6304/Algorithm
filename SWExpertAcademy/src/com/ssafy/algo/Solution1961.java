package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1961 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			String[][] inp = new String[N][N];
			String[][] matrix = new String[N][3];
			for(int i = 0; i < matrix.length; i++)
				for(int j = 0; j < matrix[i].length; j++) 
					matrix[i][j] = " ";
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					inp[i][j] = st.nextToken();
			}
			
			for(int i = 0; i < N; i++)
				for(int j = N - 1; j >= 0; j--)
					matrix[i][0].concat(inp[j][i] + "");
			
			for(int i = 0; i < N; i++)
				for(int j = N - 1; j >= 0; j--)
					matrix[i][1].concat(inp[i][j] + "");
			
			for(int i = N - 1; i >= 0; i--)
				for(int j = 0; j < N; j++)
					matrix[i][2].concat(inp[j][i] + "");
			
			System.out.println("#" + testCase);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 3; j++)
					System.out.print(matrix[i][j].trim() + " ");
				System.out.println();
			}
		}
		
		bw.close();
	}
}