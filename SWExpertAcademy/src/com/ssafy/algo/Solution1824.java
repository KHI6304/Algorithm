package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1824 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			char[][] map = new char[row][col];
			
			for(int i = 0; i < row; i++)
				map[i] = br.readLine().toCharArray();
			
			int memory = 0;
			// 상, 하, 좌, 우
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};
			boolean[][][][] visited = new boolean[row][col][4][16];
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {0, 0, 3, memory});
			visited[0][0][3][memory] = true;
			
			boolean ffff = false;
			boolean dddd = true;
			for(int i = 0; i < row & dddd; i++) {
				for(int j = 0; j < col & dddd; j++)
					if(map[i][j] == '@') {
						ffff = true;
						int cnt = 0;
						for(int k = 0; k < 4; k++) {
							int tmpR = i + dx[k];
							int tmpC = j + dy[k];
							
							int[] tmpArrrr = inRange(tmpR, tmpC);
							tmpR = tmpArrrr[0];
							tmpC = tmpArrrr[1];
							
							if(k == 0) {
								if(map[tmpR][tmpC] == '<' || map[tmpR][tmpC] == '^' || map[tmpR][tmpC] == '>') {
									cnt++;
								}
							}
							else if(k == 1) {
								if(map[tmpR][tmpC] == '<' || map[tmpR][tmpC] == 'v' || map[tmpR][tmpC] == '>') {
									cnt++;
								}
							}
							else if(k == 2) {
								if(map[tmpR][tmpC] == '<' || map[tmpR][tmpC] == '^' || map[tmpR][tmpC] == 'v') {
									cnt++;
								}
							}
							else if(k == 3) {
								if(map[tmpR][tmpC] == 'v' || map[tmpR][tmpC] == '^' || map[tmpR][tmpC] == '>') {
									cnt++;
								}
							}
							if(cnt == 4) {
								dddd = false;
								break;
							}
						}
					}
			}
			
			if(!ffff || !dddd) {
				System.out.println("#" + tc + " NO");
				continue;
			}
			
			boolean flag = false;
			while(!q.isEmpty() && !flag) {
				int[] tmp = q.poll();
				int x = tmp[0];
				int y = tmp[1];
				int d = tmp[2];
				
				if( Character.isDigit(map[x][y]) )
					memory = map[x][y] - '0';
				else if(map[x][y] == '<')
					d = 2;
				else if(map[x][y] == '>')
					d = 3;
				else if(map[x][y] == '^')
					d = 0;
				else if(map[x][y] == 'v')
					d = 1;
				else if(map[x][y] == '_') {
					if(memory == 0)
						d = 3;
					else
						d = 2;
				}
				else if(map[x][y] == '|') {
					if(memory == 0)
						d = 1;
					else
						d = 0;
				}
				else if(map[x][y] == '+') {
					if(memory == 15)
						memory = 0;
					else
						memory += 1;
				}
				else if(map[x][y] == '-') {
					if(memory == 0)
						memory = 15;
					else
						memory -= 1;
				} 
				else if(map[x][y] == '@') {
					flag = true;
					break;
				}
				
				if(map[x][y] == '?') {
					for(int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						int[] arrtmp = inRange(nx, ny);
						
						nx = arrtmp[0];
						ny = arrtmp[1];
						
						if(map[nx][ny] == '@') {
							flag = true;
							break;
						}
						
						if(visited[nx][ny][i][memory] == true)
							continue;
						
						q.add(new int[] {nx, ny, i, memory});
					}
					continue;
				}
				
				x += dx[d];
				y += dy[d];
				int[] arrtmp = inRange(x, y);
				
				x = arrtmp[0];
				y = arrtmp[1];
				
				if(visited[x][y][d][memory] == true)
					continue;
				
				visited[x][y][d][memory] = true;
				
				q.add(new int[] {x, y, d, memory});
			}
			
			if(flag)
				System.out.println("#" + tc + " YES");
			else
				System.out.println("#" + tc + " NO");
		}
	}
	
	static int row;
	static int col;
	static int[] inRange(int nx, int ny) {
		if(nx < 0)
			nx = row - 1;
		if(ny < 0)
			ny = col - 1;
		if(nx >= row)
			nx = 0;
		if(ny >= col)
			ny = 0;
		
		return new int[] {nx, ny};
	}
}
//#1 YES
//#2 NO
//#3 YES
//#4 YES
//#5 YES
//#6 YES
//#7 NO
//#8 NO
//#9 YES
//#10 YES
//#11 YES
//#12 YES
//#13 YES
//#14 NO
//#15 YES
//#16 YES
//#17 YES
//#18 YES
//#19 YES
//#20 YES
//#21 YES
//#22 YES
//#23 YES
//#24 YES
//#25 YES
//#26 YES
//#27 YES
//#28 YES
//#29 YES
//#30 YES
//#31 YES
//#32 YES
//#33 YES
//#34 YES
//#35 NO
//#36 YES
//#37 YES
//#38 YES
//#39 NO
//#40 NO
//#41 YES
//#42 YES
//#43 NO
//#44 YES
//#45 YES
//#46 YES
//#47 YES
//#48 NO
//#49 NO
//#50 YES
//#51 NO
//#52 YES
//#53 YES
//#54 YES
//#55 YES
//#56 YES
//#57 NO
//#58 YES
//#59 YES 틀림
//#60 NO
//#61 YES 틀림
//#62 YES
//#63 NO