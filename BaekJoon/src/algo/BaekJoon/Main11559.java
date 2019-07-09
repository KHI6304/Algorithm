package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main11559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6];
		
		for(int i = 0; i < 12; i++)
			map[i] = br.readLine().toCharArray();
		
		while(flag) {
			for(int i = 0; i < colors.length; i++) {
				
			}
		}
	}
	
	static char[][] map;
	static int sol;
	static boolean flag = true;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[] colors = {'R', 'G', 'B', 'P', 'Y'};
	
	static void Solve(char color) {
		Queue<Character> q = new LinkedList<>();
		
	}
	
	static void MapDown() {
		for(int i = 0; i < map[0].length; i++) {
			for(int j = map.length - 1; j >= 0; j--) {
				if(map[j][i] == '.')
					continue;
				
				for(int k = map.length - 1; k > j; k--) {
					if(map[k][i] == '.') {
						char tmp = map[j][i];
						map[j][i] = map[k][i];
						map[k][i] = tmp;
						break;
					}
				}
			}
		}
	}
}