package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution4013 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			List<Integer>[] list = new LinkedList[4];
			for(int i = 0; i < 4; i++) {
				list[i] = new LinkedList<>();
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++)
					list[i].add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				switch(idx) {
				case 1:
					if( list[0].get(2) != list[1].get(6) ) {
						if( list[1].get(2) != list[2].get(6) ) {
							if( list[2].get(2) != list[3].get(6) ) {
								rotation(list[3], -dir);
							}
							rotation(list[2], dir);
						}
						rotation(list[1], -dir);
					}
					break;
				case 2:
					if( list[0].get(2) != list[1].get(6) ) {
						rotation(list[0], -dir);
					}
					if( list[1].get(2) != list[2].get(6) ) {
						if( list[2].get(2) != list[3].get(6) ) {
							rotation(list[3], dir);
						}
						rotation(list[2], -dir);
					}
					break;
				case 3:
					if( list[2].get(2) != list[3].get(6) ) {
						rotation(list[3], -dir);
					}
					if( list[1].get(2) != list[2].get(6) ) {
						if( list[0].get(2) != list[1].get(6) ) {
							rotation(list[0], dir);
						}
						rotation(list[1], -dir);
					}
					break;
				case 4:
					if( list[2].get(2) != list[3].get(6) ) {
						
						if( list[1].get(2) != list[2].get(6) ) {
							
							if( list[0].get(2) != list[1].get(6) ) {
								rotation(list[0], -dir);
							}
							rotation(list[1], dir);
						}
						
						rotation(list[2], -dir);
					}
					break;
				}
				
				rotation(list[idx - 1], dir);
			}
			
			int sum = 0;
			for(int i = 0; i < 4; i++) {
				if(list[i].get(0) == 1)
					sum += Math.pow(2, i);
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
	
	static void rotation(List<Integer> list, int dir) {
		if(dir == 1) {
			int tmp = list.get(7);
			list.remove(7);
			list.add(0, tmp);
		} else {
			int tmp = list.get(0);
			list.remove(0);
			list.add(tmp);
		}
	}
}