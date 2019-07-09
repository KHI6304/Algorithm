package com.ssafy.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int T = 1; T <= 10; T++) {
			int N = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i = 0; i < 8; i++)
				queue.add(sc.nextInt());
			
			int sub = 1;
			while(true) {
				int num = queue.poll();
				if(sub == 6)
					sub %= 5;
				if(num - sub <= 0) {
					queue.add(0);
					break;
				}
				queue.add(num - sub);
				sub++;
			}
			System.out.printf("#%d ", T);
			while(!queue.isEmpty())
				System.out.print(queue.poll() + " ");
			System.out.println();
		}
	}
}