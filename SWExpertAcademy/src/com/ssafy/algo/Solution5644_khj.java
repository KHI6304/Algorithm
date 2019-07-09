package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution5644_khj {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int time = sc.nextInt();
			int bc = sc.nextInt();
			int[] A = new int[time+1];
			int[] B = new int[time+1];
			list = new ArrayList[11][11];
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					list[i][j] = new ArrayList<>();
				}
			}
			for (int i = 1; i < time+1; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 1; i < time+1; i++) {
				B[i] = sc.nextInt();
			}
			for (int i = 0; i < bc; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int c = sc.nextInt();
				int p = sc.nextInt();
				bfs(x, y, c, p);
			}
			
			for(int i = 1; i <= 10; i++) {
				for(int j = 1; j <= 10; j++) {
					System.out.print(list[i][j].size() + " ");
				}
				System.out.println();
			}
			
			int ax = 1;
			int ay = 1;
			int bx = 10;
			int by = 10;
			int asum = 0;
			int bsum = 0;
			for (int k = 0; k < time+1; k++) {
				ax += dxx[A[k]];
				ay += dyy[A[k]];
				bx += dxx[B[k]];
				by += dyy[B[k]];
				
				int asize = list[ax][ay].size();
				int bsize = list[bx][by].size();
				
				Collections.sort(list[ax][ay]);
				Collections.sort(list[bx][by]);
				
				if(asize == 0 && bsize == 0) {
					continue;
				}else if(bsize == 0) {
					int max = list[ax][ay].get(asize-1);
					asum += max;
				}else if(asize == 0) {
					int max = list[bx][by].get(bsize-1);
					bsum += max;
				}else if(asize == 1 && bsize == 1) {
					if( list[ax][ay].get(0) == list[bx][by].get(0)) {
						asum += list[ax][ay].get(0);
					}else {
						asum += list[ax][ay].get(0);
						bsum += list[bx][by].get(0);
					}
				}else if(asize > 1 && bsize == 1) {
					int bval = list[bx][by].get(0);
					int max = list[ax][ay].get(asize-1);
					
					if(bval != max) {
						asum += max;
						bsum += bval;
					}else {
						asum += list[ax][ay].get(asize-2);
						bsum += bval;
					}
				}else if(bsize > 1 && asize == 1) {
					int aval = list[ax][ay].get(0);
					int max = list[bx][by].get(bsize-1);
					
					if(aval != max) {
						bsum += max;
						asum += aval;
					}else {
						bsum += list[bx][by].get(bsize-2);
						asum += aval;
					}
				}else {
					int amax = list[ax][ay].get(asize-1);
					int bmax = list[bx][by].get(bsize-1);
		
					if(amax != bmax) {
						bsum += bmax;
						asum += amax;
					}else{
						int amax2 = list[ax][ay].get(asize-2);
						int bmax2 = list[bx][by].get(bsize-2);
						if(amax2 > bmax2) {
							bsum += bmax;
							asum += amax2;
						}else {
							bsum += bmax2;
							asum += amax;
						}
					}
				}
				
			}
			System.out.println(asum+bsum);
		}
	}
	static List<Integer>[][] list; 
	static int[][] map;
	static void bfs(int x, int y, int c, int p) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		
		list[x][y].add(0, p);
		
		while(!q.isEmpty()) {
			Point po = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = po.x + dx[i];
				int ny = po.y + dy[i];
				if(nx < 1 || ny < 1 || nx >= 11 || ny >= 11) {
					continue;
				}
				if((list[nx][ny].isEmpty() || list[nx][ny].get(0) != p) && po.cnt < c) {
					q.add(new Point(nx, ny, po.cnt+1));
					list[nx][ny].add(0,p);
				}
			}
		}
	}
	
	static int[] dxx = {0, -1, 0, 1, 0};
	static int[] dyy = {0, 0, 1, 0, -1};
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Point{
		int x;
		int y; 
		int cnt;
		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
}
