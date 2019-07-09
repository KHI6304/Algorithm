package com.ssafy.algo;

import java.util.Scanner;

public class Solution5650_khj {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      for (int t = 1; t <= T; t++) {
         n = sc.nextInt();
         map = new int[n][n];
         int[] dx = { -1, 1, 0, 0 };
         int[] dy = { 0, 0, -1, 1 };
         for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
               map[i][j] = sc.nextInt();
            }
         }
         max = 0;
         for (int i = 4; i < map.length; i++) {
            for (int j = 3; j < map.length; j++) {
               if (map[i][j] == 0) {
                  for (int k = 1; k < 4; k++) {
                	 System.out.println(i + " : " + j + " : " + k);
                     dfs(i, j, k, i, j, k, 0);
                  }
               }
            }
         }
         System.out.println(max);
      }
   }
   static int n, max;
   static int[][] map;
   static boolean[][][] visit;

   static void dfs(int sx, int sy, int sd, int x, int y, int d, int cnt) {
      if(sd != d && sx == x && sy == y) {
    	 max = Math.max(max, cnt);
         return;
      }
      if (map[x][y] == -1) {
         max = Math.max(max, cnt);
         return;
      }
      
      
      if (d == 0) {// 상
         if(x-1 <0) {
            dfs(sx, sy, sd, x, y, 1, cnt+1);
         }
         else if(x-1 >=0 && (map[x-1][y] == 1 || map[x-1][y] == 4 || map[x-1][y] == 5)) {
            dfs(sx, sy, sd, x-1, y, 1, cnt+1);
         }else if(x-1 >=0 && map[x-1][y] == 0) {
            dfs(sx, sy, sd, x-1, y, d, cnt);
         }else if(x-1 >=0 && map[x-1][y] == 2) {
            dfs(sx, sy, sd, x-1, y, 3, cnt+1);
         }else if(x-1 >=0 && map[x-1][y] == 3) {
            dfs(sx, sy, sd, x-1, y, 2, cnt+1);
         }else if(x-1 >=0 && map[x-1][y] > 5 && map[x-1][y] <=10 ) {
            for (int i = 0; i < map.length; i++) {
               for (int j = 0; j < map.length; j++) {
                  if(map[i][j] == map[x-1][y] && (i != x-1 || j != y) ) {
                     dfs(sx, sy, sd, i, j, d, cnt);                     
                  }
               }
            }
         }else {
            dfs(sx, sy, sd, x-1, y, d, cnt);
         }
      } else if (d == 1) {//하
         if(x+1 >= n) {
            dfs(sx, sy, sd, x, y, 0, cnt+1);
         }
         else if(x+1 < n && (map[x+1][y] == 2 || map[x+1][y] == 3 || map[x+1][y] == 5)) {
            dfs(sx, sy, sd, x+1, y, 0, cnt+1);
         }else if(x+1 < n && map[x+1][y] == 0) {
            dfs(sx, sy, sd, x+1, y, d, cnt);
         }else if(x+1 < n && map[x+1][y] == 1) {
            dfs(sx, sy, sd, x+1, y, 3, cnt+1);
         }else if(x+1 < n && map[x+1][y] == 4) {
            dfs(sx, sy, sd, x+1, y, 2, cnt+1);
         }else if(x+1 < n && map[x+1][y] > 5 && map[x+1][y] <=10 ) {
            for (int i = 0; i < map.length; i++) {
               for (int j = 0; j < map.length; j++) {
                  if (map[i][j] == map[x + 1][y] && (i != x + 1 || j != y ) ) {
                     dfs(sx, sy, sd, i, j, d, cnt);
                  }
               }
            }
         }else {
            dfs(sx, sy, sd, x+1, y, d, cnt);
         }

      } else if (d == 2) {//좌
         if(y-1 <0) {
            dfs(sx, sy, sd, x, y, 3, cnt+1);
         }
         else if( y-1 >= 0 &&(map[x][y-1] == 3 || map[x][y-1] == 4 || map[x][y-1] == 5)) {
            dfs(sx, sy, sd, x, y-1, 3, cnt+1);
         }else if(y-1 >= 0 &&map[x][y-1] == 0) {
            dfs(sx, sy, sd, x, y-1, d, cnt);
         }else if(y-1 >= 0 &&map[x][y-1] == 1) {
            dfs(sx, sy, sd, x, y-1, 0, cnt+1);
         }else if(y-1 >= 0 &&map[x][y-1] == 2) {
            dfs(sx, sy, sd, x, y-1, 1, cnt+1);
         }else if(y-1 >= 0 &&map[x][y-1] > 5 && map[x][y-1] <=10 ) {
            for (int i = 0; i < map.length; i++) {
               for (int j = 0; j < map.length; j++) {
                  if (map[i][j] == map[x][y-1] && (i != x || j != y-1 )) {
                     dfs(sx, sy, sd, i, j, d, cnt);
                  }
               }
            }
         }else  {
            dfs(sx, sy, sd, x, y-1, d, cnt);
         }

      } else if (d == 3) {//우
         if(y+1 >= n ) {
            dfs(sx, sy, sd, x, y, 2, cnt+1);
         }
         else if(y+1 < n  && (map[x][y+1] == 1 || map[x][y+1] == 2 || map[x][y+1] == 5)) {
            dfs(sx, sy, sd, x, y+1, 2, cnt+1);
         }else if(y+1 < n  &&y+1 < n  &&map[x][y+1] == 0) {
            dfs(sx, sy, sd, x, y+1, d, cnt);
         }else if(y+1 < n  &&y+1 < n  &&map[x][y+1] == 3) {
            dfs(sx, sy, sd, x, y+1, 1, cnt+1);
         }else if(y+1 < n  &&y+1 < n  &&map[x][y+1] == 4) {
            dfs(sx, sy, sd, x, y+1, 0, cnt+1);
         }else if(y+1 < n  &&map[x][y+1] > 5 && map[x][y+1] <=10 ) {
            for (int i = 0; i < map.length; i++) {
               for (int j = 0; j < map.length; j++) {
                  if (map[i][j] == map[x][y+1] && (i != x || j != y+1) ) {
                     dfs(sx, sy, sd, i, j, d, cnt);
                  }
               }
            }
         }else  {
            dfs(sx, sy, sd, x, y+1, d, cnt);
         }

      }
   }

}