package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10830 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		
		mat = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				mat[i][j] = Integer.parseInt(st.nextToken()) % 1000;
		}
		
		int[][] sol = powMat(X);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				System.out.print(sol[i][j] + " ");
			System.out.println();
		}
	}
	
	private static int N;
	private static long X;
	private static int[][] mat;
	
	private static int[][] powMat(long n) {
		if(n == 1)
			return mat;
		
		int[][] tmp = powMat(n / 2);
		int[][] mul = mulMat(tmp, tmp);
		
		if(n % 2 == 0) return mul;
		else return mulMat(mul, mat);
	}
	
	private static int[][] mulMat(int[][] matA, int[][] matB) {
		int[][] mat = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					mat[i][j] += matA[i][k] * matB[k][j];
					mat[i][j] %= 1000;
				}
			}
		}
		
		return mat;
	}
}