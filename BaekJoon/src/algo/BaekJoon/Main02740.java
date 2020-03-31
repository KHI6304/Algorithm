package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02740 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int rowA = Integer.parseInt(st.nextToken());
		int colA = Integer.parseInt(st.nextToken());
		
		int[][] matA = new int[rowA][colA];
		for(int i = 0; i < rowA; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < colA; j++)
				matA[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int rowB = Integer.parseInt(st.nextToken());
		int colB = Integer.parseInt(st.nextToken());
		
		int[][] matB = new int[rowB][colB];
		for(int i = 0; i < rowB; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < colB; j++)
				matB[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] sol = new int[rowA][colB];
		for(int r = 0; r < rowA; r++) {
			for(int c = 0; c < colB; c++) {
				for(int i = 0; i < colA; i++)
					sol[r][c] += matA[r][i] * matB[i][c];
			}
		}
		
		for(int r = 0; r < sol.length; r++) {
			for(int c = 0; c < sol[0].length; c++)
				System.out.print(sol[r][c] + " ");
			System.out.println();
		}
	}
}