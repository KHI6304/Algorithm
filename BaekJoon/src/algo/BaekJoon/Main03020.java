package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main03020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] bot = new int[N / 2];
		int[] top = new int[N / 2];
		
		for(int i = 0; i < N / 2; i++) {
			bot[i] = Integer.parseInt(br.readLine());
			top[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bot);
		Arrays.sort(top);
		
		int sol = N;
		int solCnt = 0;
		for(int h = 1; h <= H; h++) {
			int cnt = 0;
			
			cnt += bot.length - lowerBound(bot, h);
			cnt += top.length - lowerBound(top, H - h + 1);
			
			if(cnt < sol) {
				sol = cnt;
				solCnt = 1;
			}
			else if(sol == cnt)
				solCnt++;
		}
		
		System.out.println(sol + " " + solCnt);
	}
	
	private static int lowerBound(int[] arr, int val) {
		int left = 0;
		int right = arr.length;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(val <= arr[mid])
				right = mid;
			else
				left = mid + 1;
		}
		
		return right;
	}
}