package jungol.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL2634 {
	static class Animal implements Comparable<Animal> {
		int x;
		int y;
		
		public Animal(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Animal o) {
			// TODO Auto-generated method stub
			if(x - o.x == 0)
				return y - o.y;
			return x - o.x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// M(사대) , N(동물), L(사정거리)
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		// 사대 입력
		int[] ms = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++)
			ms[i] = Integer.parseInt(st.nextToken());
		
		// 동물 입력
		Animal[] as = new Animal[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			as[i] = new Animal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 동물 및 사대를 x좌표 기준으로 정렬
		Arrays.sort(ms);
		Arrays.sort(as);
		
		// 동물 객체 배열을 탐색하며, 해당 동물의 좌우 사대에서 잡을 수 있는지 확인
		int sol = 0;
		int idx = 0;
		for(int i = 0; i < N; i++) {
			while(idx != M - 1 && ms[idx + 1] < as[i].x)
				idx++;
			
			if(isKill( as[i].x, as[i].y, ms[idx] )) {
				sol++;
				continue;
			}
			
			if(idx != M - 1) {
				if(isKill( as[i].x, as[i].y, ms[idx + 1] )) {
					sol++;
					continue;
				}
			}
		}
		System.out.println(sol);
	}
	
	static int L;
	static boolean isKill(int ax, int ay, int mx) {
		if( Math.abs(ax - mx) + ay <= L )
			return true;
		return false;
	}
}