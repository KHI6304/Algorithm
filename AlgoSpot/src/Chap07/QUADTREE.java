package Chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QUADTREE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			String inp = br.readLine();
			
			System.out.println(reverse(inp));
		}
	}
	
	static String reverse(String str) {
		if( str.charAt(0) == 'b' || str.charAt(0) == 'w' )
			return str.charAt(0) + "";
		
		String rqt[] = new String[4];
		
		int beginIdx = 1;
		rqt[0] = reverse(str.substring(beginIdx));
		
		beginIdx += rqt[0].length();
		rqt[1] = reverse(str.substring(beginIdx));
		
		beginIdx += rqt[1].length();
		rqt[2] = reverse(str.substring(beginIdx));
		
		beginIdx += rqt[2].length();
		rqt[3] = reverse(str.substring(beginIdx));
		
		return 'x' + rqt[2] + rqt[3] + rqt[0] + rqt[1];
	}
}
