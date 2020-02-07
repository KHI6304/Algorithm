package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main07568 {
	/*
	 * People 클래스 배열을 통해서 rank 값을 정해주는 것이 포인트이다.
	 * 각 사람에 대해 자신을 재외한 모든 사람과의 비교를 통해 rank 값을 정해준다.
	 */
	
	static class People{
		int w;
		int h;
		int rank;
		
		public People(int w, int h) {
			this.w = w;
			this.h = h;
			this.rank = 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		People[] ps = new People[N];
	
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ps[i] = new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < ps.length; i++) {
			for(int j = 0; j < ps.length; j++) {
				if(i == j) continue;
				
				if(ps[i].w < ps[j].w && ps[i].h < ps[j].h)
					ps[i].rank++;
			}
		}
		
		for(int i = 0; i < ps.length; i++)
			System.out.printf(ps[i].rank + " ");
		System.out.println();
	}
}