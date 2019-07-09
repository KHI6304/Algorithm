package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1873 {
	static int H;
	static int W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			
			for(int row = 0; row < H; row++) {
				map[row] = br.readLine().toCharArray();
				
				for(int col = 0; col < W; col++) {
					if(map[row][col] == '^' || map[row][col] == 'v' 
							|| map[row][col] == '<' || map[row][col] == '>') {
						X = row;
						Y = col;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String command = br.readLine();
			for(int i = 0; i < N; i++)
				DoCommand(map, command.charAt(i));
			
			bw.write("#" + tc + " ");
			for(int row = 0; row < H; row++) {
				for(int col = 0; col < W; col++)
					bw.write(map[row][col]);
				bw.write("\n");
			}
		}
		bw.close();
	}
	
	static int X, Y;
	static void DoCommand(char[][] map, char command) {
		switch(command) {
		case 'U' :
			map[X][Y] = '^';
			if(X - 1 < 0)
				break;
			else if(map[X - 1][Y] != '.')
				break;
			else if(map[X - 1][Y] == '.') {
				map[X][Y] = '.';
				X -= 1;
				map[X][Y] = '^';
			}
			break;
		case 'D' :
			map[X][Y] = 'v';
			if(X + 1 >= H)
				break;
			else if(map[X + 1][Y] != '.')
				break;
			else if(map[X + 1][Y] == '.') {
				map[X][Y] = '.';
				X += 1;
				map[X][Y] = 'v';
			}
			break;
		case 'L' :
			map[X][Y] = '<';
			if(Y - 1 < 0)
				break;
			else if(map[X][Y - 1] != '.')
				break;
			else if(map[X][Y - 1] == '.') {
				map[X][Y] = '.';
				Y -= 1;
				map[X][Y] = '<';
			}
			break;
		case 'R' :
			map[X][Y] = '>';
			if(Y + 1 >= W)
				break;
			else if(map[X][Y + 1] != '.')
				break;
			else if(map[X][Y + 1] == '.') {
				map[X][Y] = '.';
				Y += 1;
				map[X][Y] = '>';
			}
			break;
		case 'S' :
			switch(map[X][Y]) {
			case '^':
				int tmp1 = X - 1;
				while(tmp1 >= 0) {
					if(map[tmp1][Y] == '#')
						break;
					if(map[tmp1][Y] == '*') {
						map[tmp1][Y] = '.';
						break;
					}
					tmp1--;
				}
				break;
			case 'v':
				int tmp2 = X + 1;
				while(tmp2 < H) {
					if(map[tmp2][Y] == '#')
						break;
					if(map[tmp2][Y] == '*') {
						map[tmp2][Y] = '.';
						break;
					}
					tmp2++;
				}
				break;
			case '<':
				int tmp3 = Y - 1;
				while(tmp3 >= 0) {
					if(map[X][tmp3] == '#')
						break;
					if(map[X][tmp3] == '*') {
						map[X][tmp3] = '.';
						break;
					}
					tmp3--;
				}
				break;
			case '>':
				int tmp4 = Y + 1;
				while(tmp4 < W) {
					if(map[X][tmp4] == '#')
						break;
					if(map[X][tmp4] == '*') {
						map[X][tmp4] = '.';
						break;
					}
					tmp4++;
				}
				break;
			}
			break;
		}
	}
}