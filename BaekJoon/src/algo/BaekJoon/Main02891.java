package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < S; i++)
			arr[ Integer.parseInt(st.nextToken()) ]--;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++)
			arr[ Integer.parseInt(st.nextToken()) ] += 2;
		
		for(int i = 1; i <= N; i++) {
			if(arr[i] == -1) {
				int front = i - 1;
				int rear = i + 1;
				
				if(arr[front] == 2) {
					arr[front]--;
					arr[i] += 1;
					continue;
				}
				
				if(rear > N)
					continue;
				
				if(arr[rear] == 2) {
					arr[rear]--;
					arr[i] += 1;
				}
			}
		}
		
		int sol = 0;
		for(int i = 1; i <= N; i++)
			if(arr[i] == -1) sol++;
		
		System.out.println(sol);
	}
}