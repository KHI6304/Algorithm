package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		int sol = 0;
		for(int i = 0; i < A.length() - B.length() + 1; i++) {
			String subA = A.substring(i, i + B.length());
			
			if(subA.equals(B)) {
				sol++;
				i += B.length() - 1;
			}
		}

		System.out.println(sol);
	}
}