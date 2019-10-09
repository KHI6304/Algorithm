package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[10001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int sol = 0;
		
		int sum = arr[0];
		int low = 0, high = 0;
		while(low <= high && high < N) {
			if(sum < M)
				sum += arr[++high];
			else if(sum == M) {
				sol++;
				sum += arr[++high];
			}
			else if(sum > M) {
				sum -= arr[low++];
				
				if(low > high && low < N) {
					high = low;
					sum = arr[low];
				}
			}
		}
		
		System.out.println(sol);
	}
}