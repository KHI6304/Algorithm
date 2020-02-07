package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10250 {
	/*
	 * printf() 쓰고 개행문자 잊지말자......ㅠㅠ
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int floor = N % H;
			int room;
			if(N % H == 0)
				room = N / H;
			else
				room = N / H + 1;
			
			if(floor == 0)
				floor = H;
			
			System.out.printf("%d%02d\n", floor, room);
		}
	}
}