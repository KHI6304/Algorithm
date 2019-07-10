package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01074 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		solve(0, 0, (int) Math.pow(2, N));
	}
	
	static int N, r, c;
	static int result = 0;
	
	static void solve(int x, int y, int len) {
		if(x == r && y == c) {
			System.out.println(result);
			System.exit(0);
		}
		
		if(len == 1) {
			result++;
			return;
		}
		
		if( !(x <= r && r < x + len && y <= c && c < y + len) ) {
			result += len * len;
			return;
		}
		
		solve(x, y, len / 2);
		solve(x, y + len / 2, len / 2);
		solve(x + len / 2, y, len / 2);
		solve(x + len / 2, y + len / 2, len / 2);		
	}
}