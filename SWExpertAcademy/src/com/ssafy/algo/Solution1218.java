package com.ssafy.algo;

import java.util.Scanner;

public class Solution1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int T = 1; T <= 10; T++) {
            int cnt1 = 0;   // ()
            int cnt2 = 0;   // []
            int cnt3 = 0;   // {}
            int cnt4 = 0;   // <>
             
            int N = sc.nextInt();
            String S = sc.next();
            for(int i = 0; i < N; i++) {
                switch(S.charAt(i)) {
                case '(' : cnt1++;
                    break;
                case ')' : cnt1--;
                    break;
                case '[' : cnt2++;
                    break;
                case ']' : cnt2--;
                    break;
                case '{' : cnt3++;
                    break;
                case '}' : cnt3--;
                    break;
                case '<' : cnt4++;
                    break;
                case '>' : cnt4--;
                    break;
                }
            }
             
            if(cnt1 != 0 || cnt2 != 0 || cnt3 != 0 || cnt4 != 0)
                System.out.printf("#%d %d%n", T, 0);
            else
                System.out.printf("#%d %d%n", T, 1);
        }
    }
}