package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main11651 {
	private static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
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
		
		Arrays.sort(ps, new Comparator<Position>() {
			@Override
			public int compare(Position o1, Position o2) {
				if(o1.y == o2.y)
					return Integer.compare(o1.x, o2.x);
				return Integer.compare(o1.y, o2.y);
			}
		});
		
		for(int i = 0; i < N; i++)
			System.out.println(ps[i].x + " " + ps[i].y);
	}
}