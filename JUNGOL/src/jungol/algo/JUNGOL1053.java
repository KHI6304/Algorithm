package jungol.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JUNGOL1053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int inp = Integer.parseInt(br.readLine());
		while(inp != -1) {
			sb.append(fibo(inp)).append("\n");
			inp = Integer.parseInt(br.readLine()); 
		}
		System.out.println(sb);
	}
	
	static class Matrix {
		long[][] data = new long[2][2];

		public Matrix() {
			data[0][0] = 1;
			data[0][1] = 1;
			data[1][0] = 1;
			data[1][1] = 0;
		}
	}
	
	static Matrix mul(Matrix A, Matrix B) {
		Matrix res = new Matrix();
		res.data[0][0] = (A.data[0][0] * B.data[0][0] + A.data[0][1] * B.data[1][0]) % 10000;
		res.data[0][1] = (A.data[0][0] * B.data[0][1] + A.data[0][1] * B.data[1][1]) % 10000;
		res.data[1][0] = (A.data[1][0] * B.data[0][0] + A.data[1][1] * B.data[1][0]) % 10000 ;
		res.data[1][1] = (A.data[1][0] * B.data[0][1] + A.data[1][1] * B.data[1][1]) % 10000;
		
		return res;
	}
	
	static Matrix pow(Matrix A, int n) {
		if(n > 1) {
			A = pow(A, n / 2);
			A = mul(A, A);
			
			if(n % 2 == 1) {
				Matrix B = new Matrix();
				A = mul(A, B);
			}
		}
		return A;
	}
	
	static long fibo(int n) {
		if(n == 0)
			return 0;
		
		Matrix A = new Matrix();
		A = pow(A, n);
		return A.data[0][1];
	}
}