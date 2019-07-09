package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main04344 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int n : arr)
				sum += n;
			double avg = sum / (double)N;
			
			int cnt = 0;
			for(int n : arr)
				if(n > avg)
					cnt++;
			
			double sol = cnt / (double)N;
			sol *= 1000;
			Math.round(sol);
			sol /= 10;
			
			System.out.printf("%.3f%%\n", sol);
		}
	}
}