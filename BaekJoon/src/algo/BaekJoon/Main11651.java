package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11651 {
	/*
	 * 좌표 클래스를 만든다.
	 * 
	 */
	
	private static class Position implements Comparable<Position> {
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Position p) {
			if(p.y == y)
				return x - p.x;
			else
				return y - p.y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Position[] ps = new Position[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ps[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(ps);
		
		for(int i = 0; i < N; i++)
			System.out.println(ps[i].x + " " + ps[i].y);
	}
}