package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main02749 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		long[][] sol = powMat(n);
		
		System.out.println(sol[0][1]);
	}
	
	private static long[][] rowMat = {
			{1, 1},
			{1, 0}
	};
	
	private static long[][] powMat(long n) {
		if(n == 1)
			return rowMat;
			
		long[][] tmp = powMat(n / 2);
		long[][] mat = mulMat(tmp, tmp);
		if(n % 2 == 0) return mat;
		else return mulMat(mat, rowMat);
	}
	
	private static long[][] mulMat(long[][] A, long[][] B) {
		long[][] mat = new long[2][2];
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k < 2; k++) {
					mat[i][j] += A[i][k] * B[k][j];
					mat[i][j] %= 1000000;
				}
			}
		}
		
		return mat;
	}
}