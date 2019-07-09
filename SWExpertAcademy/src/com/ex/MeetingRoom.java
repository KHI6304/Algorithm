package com.ex;


import java.util.Scanner;

public class MeetingRoom {
	public static void main(String[] args) {
//		10
//		1 4 1 6 6 10 5 7 3 8 5 9 3 5 8 11 2 13 12 14
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] meetingTable = new int[N][2];
		for(int i = 0; i < N; i++) {
			meetingTable[i][0] = sc.nextInt();
			meetingTable[i][1] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			int minIdx = i;
			for(int j = i; j < N; j++) {
				if( meetingTable[minIdx][1] > meetingTable[j][1] ) {
					minIdx = j;
				}
			}
			int[] tmp = meetingTable[minIdx];
			meetingTable[minIdx] = meetingTable[i];
			meetingTable[i] = tmp;
		}
		// 마지막에 끝난 회의의 시간을 기억하면서
		// 새로 방문하는 회의가 시작시간이 더 늦다면, 회의를 여는걸로, cnt++하고, 마지막 끝난 회의 시간 조정하고 다음 회의 방문
		
		int cnt = 0;
		int lastFinTime = 0;
		for(int i = 0; i < N; i++) {
			if(lastFinTime < meetingTable[i][0]) {
				cnt++;
				lastFinTime = meetingTable[i][1];
			}
		}
		
		System.out.println(cnt);
	}
}
