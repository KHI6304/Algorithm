package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1808 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            
        	st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++)
                pad[i] = (Integer.parseInt(st.nextToken()) == 1);
            
            N = Integer.parseInt(br.readLine());
            ans = Integer.MAX_VALUE;
            solve(N);
            
            sb.append("#").append(tc).append(" ").append(ans == Integer.MAX_VALUE ? -1 : ans +1).append("\n");
        }
        System.out.println(sb);
    }
	
    static int N;
    static boolean[] pad = new boolean[10];
    static int ans;
    static int solve(int n) {
        if(canPress(n)) {
            if( n == N ) {
                ans = String.valueOf(n).length();
            }
            return String.valueOf(n).length();
        }
        else {
            int ret = -1;
            for(int i = n / 2; i > 1; i--) {
                if( n % i == 0 && canPress(i) ) {
                    int preCnt1 = String.valueOf(i).length() + 1;
                    int preCnt2 = solve(n/i);
                    if( preCnt2 != -1 ) {
                        ret = preCnt1 + preCnt2;
                        if( ret < ans && n == N) {
                            ans = ret;
                        }
                    }
                }
            }
            return ret;
        }
    }
    
    static boolean canPress(int n) {
        while( n > 0 ) {
            int tmp = n % 10;
            if( !pad[tmp] )
                return false;
            n /= 10;
        }
        return true;
    }
}