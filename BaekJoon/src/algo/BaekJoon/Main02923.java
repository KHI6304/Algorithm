package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02923 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[101];
		int[] B = new int[101];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			A[ Integer.parseInt(st.nextToken()) ]++;
			B[ Integer.parseInt(st.nextToken()) ]++;
			
			int cnt = 0;
			int idxA = 100, idxB = 1;
			int cntA = 0, cntB = 0;
			int sol = 0;
			
			while(cnt != i) {
				while(A[idxA] == cntA) {
					cntA = 0;
					idxA--;
				}
				
				while(B[idxB] == cntB) {
					cntB = 0;
					idxB++;
				}
				
				sol = Math.max(sol, idxA + idxB);
				
				int min = Math.min(A[idxA] - cntA, B[idxB] - cntB);
				cnt += min;
				cntA += min;
				cntB += min;
			}
			
			System.out.println(sol);
		}
	}
}