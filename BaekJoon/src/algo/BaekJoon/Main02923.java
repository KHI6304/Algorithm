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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			A[a]++;
			B[b]++;
			
			int sol = 0;
			int round = 0;
			int cntA = 0, cntB = 0;
			int idxA = 100, idxB = 1;
			while(round != i) {
				while(A[idxA] == cntA) {
					idxA--;
					cntA = 0;
				}
				while(B[idxB] == cntB) {
					idxB++;
					cntB = 0;
				}
				
				sol = Math.max(sol, idxA + idxB);
				
				int cntSub = Math.min(A[idxA] - cntA, B[idxB] - cntB);
				
				round += cntSub;
				cntA += cntSub;
				cntB += cntSub;
			}
			
			System.out.println(sol);
		}
	}
}