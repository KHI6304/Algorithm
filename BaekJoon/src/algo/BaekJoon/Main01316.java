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
			boolean[] alp = new boolean[26];
			String inp = br.readLine();
			
			if(inp.length() < 3) {
				sol++;
				continue;
			}
			
			boolean flag = true;
			for(int j = 0; j < inp.length(); j++) {
				int idx = 1;
				
				if(alp[inp.charAt(j) - 'a']) {
					flag = false;
					break;
				}
				
				if(j == inp.length() - 1)
					break;
				
				while(inp.charAt(j) == inp.charAt(j + idx)) {
					idx++;
					
					if(j + idx == inp.length())
						break;
				}
				
				alp[inp.charAt(j) - 'a'] = true;
				j += idx - 1;
			}
			
			if(flag)
				sol++;
		}
		
		System.out.println(sol);
	}
}