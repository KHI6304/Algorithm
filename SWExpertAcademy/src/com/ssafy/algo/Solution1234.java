package com.ssafy.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1234 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt();
			String s = sc.next();
			
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < s.length(); i++)
				list.add(s.charAt(i) - '0');
			
			int index = 0;
			while(true) {
				if(index + 1 >= list.size())
					break;
				
				if(index < 0)
					index = 0;
				
				if(list.get(index) == list.get(index + 1)) {
					list.remove(index);
					list.remove(index);
					index--;
				}
				else
					index++;
			}
			
			System.out.print("#" + testCase + " ");
			for(int i : list)
				System.out.print(i);
			System.out.println();
		}
	}
}