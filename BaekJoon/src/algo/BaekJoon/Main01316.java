package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sol = 0;
		for(int i = 0; i < N; i++) {
			int[] alpa = new int[26];
			String inp = br.readLine();
			
			for(int j = 0; j < inp.length(); j++) {
				char c = inp.charAt(j);
				alpa[c - 'a']++;
			}
			
			for(int j = 0; j < alpa.length; j++)
				if(alpa[j] > 1)
					continue;
			
			sol++;
		}
	}
}