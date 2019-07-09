package com.ssafy.algo;

import java.util.Scanner;
 
public class Solution1865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); //N(1 ≤ N ≤ 16) 일,사람의 수
            double[][] P = new double[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++)
                    P[i][j] = sc.nextInt()/100.0;
            }
            
            ans = 0;
            dfs(P, new boolean[N], 0, 1);
            System.out.printf("#%d %.6f\n",tc,ans*100);
        }
    }
    
    static double ans;
    static void dfs(double[][] P, boolean[] sel, int idx, double val) {
        if( ans >= val) {
            return;
        }
        
        if(idx == P.length) {
            //모두 배정했음ㅎ
            ans = Math.max(ans, val);
            return;
        }
        
        for(int i = 0; i < P.length; i++) {
            if( !sel[i] ) {
                sel[i] = true;
                dfs(P, sel, idx+1, val*P[idx][i]);
                sel[i] = false;     
            }
        }
         
    }
}