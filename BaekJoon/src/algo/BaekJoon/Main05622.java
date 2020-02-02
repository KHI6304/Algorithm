package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main05622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] inp = br.readLine().toCharArray();
		
		String[] dial = {
				"",
				"ABC",
				"DEF",
				"GHI",
				"JKL",
				"MNO",
				"PQRS",
				"TUV",
				"WXYZ"
		};
		
		int sol = inp.length * 2;
		for(int i = 0; i < inp.length; i++) {
			for(int j = 1; j < dial.length; j++) {
				if(dial[j].contains(inp[i] + "")) {
					sol += j;
					break;
				}
			}
		}
		
		System.out.println(sol);
	}
}