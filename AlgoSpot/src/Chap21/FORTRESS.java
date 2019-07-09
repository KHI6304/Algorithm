package Chap21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class FORTRESS {
	static class Circle {
		int x;
		int y;
		int r;
		
		public Circle(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	
	static class Tree {
		LinkedList<Circle> ChildNode;
		
		public Tree() {
			ChildNode = new LinkedList<>();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Circle[] circles = new Circle[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				circles[i] = new Circle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
		}
	}
}