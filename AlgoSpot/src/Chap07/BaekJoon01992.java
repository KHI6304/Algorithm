package Chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon01992 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j < N; j++)
				arr[i][j] = tmp[j] - '0';
		}
		
		Compression(arr, 0, 0, N);
		System.out.println(sol.toString());
	}
	
	static StringBuffer sol = new StringBuffer();
	
	static void Compression(int[][] arr, int x, int y, int size) {
		int tmp = arr[x][y];
		boolean isSame = true;
		for(int i = x; (i < x + size) && isSame; i++) {
			for(int j = y; (j < y + size) && isSame; j++) {
				if( tmp != arr[i][j] )
					isSame = false;
			}
		}
		
		if( isSame )
			sol.append(tmp);
		else {
			sol.append('(');
			Compression(arr, x, y, size / 2);
			Compression(arr, x, y + size / 2, size / 2);
			Compression(arr, x + size / 2, y, size / 2);
			Compression(arr, x + size / 2, y + size / 2, size / 2);
			sol.append(')');
		}
	}
}
