package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main04716 {
	private static class Team implements Comparable<Team> {
		int num, Da, Db;

		public Team(int num, int Da, int Db) {
			this.num = num;
			this.Da = Da;
			this.Db = Db;
		}

		@Override
		public int compareTo(Team t) {
			return -Integer.compare(Math.abs(Da - Db), Math.abs(t.Da - t.Db));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(N == 0) break;
			
			Team[] teams = new Team[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int Da = Integer.parseInt(st.nextToken());
				int Db = Integer.parseInt(st.nextToken());
				
				teams[i] = new Team(num, Da, Db);
			}
			
			Arrays.sort(teams);
			
			int sol = 0;
			for(int i = 0; i < N; i++) {
				
				if(teams[i].Da < teams[i].Db) {
					if(teams[i].num <= A) {
						A -= teams[i].num;
						sol += teams[i].Da * teams[i].num;
					}
					else {
						teams[i].num -= A;
						sol += A * teams[i].Da;
						A = 0;
						
						B -= teams[i].num;
						sol += teams[i].Db * teams[i].num;
					}
				}
				else {
					if(teams[i].num <= B) {
						B -= teams[i].num;
						sol += teams[i].Db * teams[i].num;
					}
					else {
						teams[i].num -= B;
						sol += B * teams[i].Db;
						B = 0;
						
						A -= teams[i].num;
						sol += teams[i].Da * teams[i].num;
					}
				}
				
			}
			
			System.out.println(sol);
		}
	}
}