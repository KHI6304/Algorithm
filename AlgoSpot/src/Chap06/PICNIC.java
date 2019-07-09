package Chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PICNIC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken().trim());
			int m = Integer.parseInt(st.nextToken().trim());
			
			isFriend = new boolean[n][n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				int a = Integer.parseInt(st.nextToken().trim());
				int b = Integer.parseInt(st.nextToken().trim());
				
				isFriend[a][b] = isFriend[b][a] = true;
			}
			
			
			System.out.println(countPairings(new boolean[n]));
		}
	}
	
	static boolean[][] isFriend;
	
	static int countPairings(boolean[] taken) {
		int firstFree = -1;
		
		for(int i = 0; i < taken.length; i++) {
			if( !taken[i] ) {
				firstFree = i;
				break;
			}
		}
		
		if( firstFree == -1 ) return 1;
		int ret = 0;
		
		/***********************************************************************
		 * 1. countPairings 메소드로 짝 맞추기의 기준이 되는 학생을 선택한다.
		 * 2. for문으로 기준이 되는 학생의 '친구'를 골라 한쌍으로 만든다.
		 * 3. 위의 한쌍을 제외한 가장 빠른 출석번호의 학생을 찾아 반복한다. (첫번째 재귀 함수 실행중)
		 * 4. 모든 학생이 짝 맞추기가 완료되면 하나의 경우를 만족했으므로 1을 반환한다.
		 * 5. 처음으로 돌아와 for문으로 1 학생의 다음 친구를 찾는다.
		 * 6. 1-5를 반복한다. 
		***********************************************************************/
		
		for(int pairWith = firstFree + 1; pairWith < taken.length; pairWith++) {
			if( !taken[pairWith] && isFriend[firstFree][pairWith] ) {
				taken[firstFree] = taken[pairWith] = true;
				ret += countPairings(taken);
				taken[firstFree] = taken[pairWith] = false;
			}
		}
		
		return ret;
	}
}