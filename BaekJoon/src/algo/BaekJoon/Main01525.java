package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		answer.append("123456780");
		StringBuilder map = new StringBuilder();
		for(int r = 0; r < 3; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 3; c++)
				map.append(st.nextToken());
		}
		
		sb.append(map.toString() + ",");
		solve(map, map.indexOf("0"), 0);
		
		if(sol == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(sol);
	}
	
	static int sol = Integer.MAX_VALUE;
	static int[] d = {-3, -1, +1, +3};
	static StringBuilder answer = new StringBuilder();
	static StringBuilder sb = new StringBuilder();
	
	static void solve(StringBuilder strb, int p, int cnt) {
		for(int i = 0; i < 4; i++) {
			int np = p + d[i];
			
			if(strb.indexOf(answer.toString()) != -1) {
				sol = Math.min(sol, cnt);
				return;
			}
			
			if(!inRange(np))
				continue;
			
			StringBuilder tmp = new StringBuilder();
			tmp.append(strb.toString());
			char tmpChar = tmp.charAt(np);
			tmp.setCharAt(np, '0');
			tmp.setCharAt(p, tmpChar);

			if(sb.indexOf(tmp.toString()) != -1)
				return;
			
			sb.append(tmp.toString() + ",");
			
			solve(tmp, np, cnt + 1);
		}
	}
	
	static boolean inRange(int np) {
		return np >= 0 && np < 9;
	}
	
}