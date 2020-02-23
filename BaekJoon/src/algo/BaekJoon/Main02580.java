package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main02580 {
	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[9][9];
		list = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 0)
					list.add(new Node(i, j));
			}
		}
		
		solve(0);
	}
	
	private static int[][] map;
	private static ArrayList<Node> list;
	private static boolean flag = false;
	
	private static boolean isOk(int x, int y, int num) {
		for(int i = 0; i < 9; i++) {
			if(map[i][y] == num) return false;
			if(map[x][i] == num) return false;
		}
		
		int tmpX = x - x % 3;
		int tmpY = y - y % 3;
		
		for(int i = tmpX; i < tmpX + 3; i++)
			for(int j = tmpY; j < tmpY + 3; j++)
				if(map[i][j] == num)
					return false;
		
		return true;
	}
	
	private static void solve(int depth) {
		if(depth == list.size()) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++)
					System.out.print(map[i][j] + " ");
				System.out.println();
			}
			
			flag = true;
			return;
		}
		if(flag)
			return;
		
		int x = list.get(depth).x;
		int y = list.get(depth).y;
		
		for(int i = 1; i <= 9; i++) {
			if(!isOk(x, y, i)) continue;
			
			map[x][y] = i;
			solve(depth + 1);
			map[x][y] = 0;
		}
	}
}