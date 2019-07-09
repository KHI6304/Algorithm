package com.ssafy.algo;

import java.util.Scanner;

public class Solution5650_khj2 {
	static class Wormhole {
		int x;
		int y;
		int num;
		
		public Wormhole(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	
	static Wormhole[] ws;
	static int wsize;
	
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      for (int t = 1; t <= T; t++) {
         n = sc.nextInt();
         map = new int[n][n];
         ws = new Wormhole[10];
		 wsize = 0;
         int[] dx = { -1, 1, 0, 0 };
         int[] dy = { 0, 0, -1, 1 };
         for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
               map[i][j] = sc.nextInt();
               if(map[i][j] >= 6 && map[i][j] <= 10)
            	   ws[wsize++] = new Wormhole(i, j, map[i][j]);
            }
         }
         max = 0;
         for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
               if (map[i][j] == 0) {
                  for (int k = 0; k < 4; k++) {
                     solve(k, k, i, j, i, j);
//                     dfs(i, j, k, i, j, k, 0);
                  }
               }
            }
         }
         System.out.println("#" + t + " " + max);
      }
   }

   static int n, max;
   static int[][] map;

   static void solve(int d, int sd, int x, int y, int sx, int sy) {
      int nx = 0;
      int ny = 0;
      int cnt = 0;
      int flag = 0;
      while (true) {
         if (flag != 0 && sx == x && sy == y) {
            if (max < cnt) {
               max = cnt;
            }
            break;
         }
         
         flag = 1;
         
         if (d == 0) {// 상
            nx = x - 1;
            ny = y;
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            	x = nx;
                y = ny;
               d = 1;
               cnt++;
               continue;
            }
            if (map[nx][ny] == 1 || map[nx][ny] == 4 || map[nx][ny] == 5) {
               x = nx;
               y = ny;
               d = 1;
               cnt++;
            } else if (map[nx][ny] == 0) {
               x = nx;
               y = ny;
            } else if (map[nx][ny] == 2) {
               x = nx;
               y = ny;
               d = 3;
               cnt++;
            } else if (map[nx][ny] == 3) {
               x = nx;
               y = ny;
               d = 2;
               cnt++;
            } else if (map[nx][ny] == -1) {
            	 if (max < cnt) {
                     max = cnt;
                  }
                  break;
            } else if (map[nx][ny] > 5 && map[nx][ny] <= 10) {
            	for(int k = 0; k < wsize; k++) {
					if( (ws[k].x != nx || ws[k].y != ny) && ws[k].num == map[nx][ny] ) {
						x = ws[k].x;
						y = ws[k].y;
						break;
					}
				}
            }
         } else if (d == 1) {// 하
            nx = x + 1;
            ny = y;
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            	x = nx;
                y = ny;
               d = 0;
               cnt++;
               continue;
            }
            if (map[nx][ny] == 2 || map[nx][ny] == 3 || map[nx][ny] == 5) {
               x = nx;
               y = ny;
               d = 0;
               cnt++;
            } else if (map[nx][ny] == 0) {
               x = nx;
               y = ny;
            } else if (map[nx][ny] == 1) {
               x = nx;
               y = ny;
               d = 3;
               cnt++;
            } else if (map[nx][ny] == 4) {
               x = nx;
               y = ny;
               d = 2;
               cnt++;
            } else if (map[nx][ny] == -1) {
            	if (max < cnt) {
                    max = cnt;
                 }
                 break;
            } else if (map[nx][ny] > 5 && map[nx][ny] <= 10) {
               for(int k = 0; k < wsize; k++) {
					if( (ws[k].x != nx || ws[k].y != ny) && ws[k].num == map[nx][ny] ) {
						x = ws[k].x;
						y = ws[k].y;
						break;
					}
				}
            }
         } else if (d == 2) {// 좌
            nx = x;
            ny = y - 1;
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            	x = nx;
                y = ny;
               d = 3;
               cnt++;
               continue;
            }
            if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) {
               x = nx;
               y = ny;
               d = 3;
               cnt++;
            } else if (map[nx][ny] == 0) {
               x = nx;
               y = ny;
               d = 2;
            } else if (map[nx][ny] == 1) {
               x = nx;
               y = ny;
               d = 0;
               cnt++;
            } else if (map[nx][ny] == 2) {
               x = nx;
               y = ny;
               d = 1;
               cnt++;
            } else if (map[nx][ny] == -1) {
            	if (max < cnt) {
                    max = cnt;
                 }
                 break;
            } else if (map[nx][ny] > 5 && map[nx][ny] <= 10) {
            	for(int k = 0; k < wsize; k++) {
					if( (ws[k].x != nx || ws[k].y != ny) && ws[k].num == map[nx][ny] ) {
						x = ws[k].x;
						y = ws[k].y;
						break;
					}
				}
            }

         } else if (d == 3) {// 우
            nx = x;
            ny = y + 1;
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            	x = nx;
                y = ny;
               d = 2;
               cnt++;
               continue;
            }
            if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5) {
               x = nx;
               y = ny;
               d = 2;
               cnt++;
            } else if (map[nx][ny] == 0) {
               x = nx;
               y = ny;
               d = 3;
            } else if (map[nx][ny] == 3) {
               x = nx;
               y = ny;
               d = 1;
               cnt++;
            } else if (map[nx][ny] == 4) {
               x = nx;
               y = ny;
               d = 0;
               cnt++;
            } else if (map[nx][ny] == -1) {
            	if (max < cnt) {
                    max = cnt;
                 }
                 break;
            } else if (map[nx][ny] > 5 && map[nx][ny] <= 10) {
            	for(int k = 0; k < wsize; k++) {
					if( (ws[k].x != nx || ws[k].y != ny) && ws[k].num == map[nx][ny] ) {
						x = ws[k].x;
						y = ws[k].y;
						break;
					}
				}
            }

         }
      }

   }

}
