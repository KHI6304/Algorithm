package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main01920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int idx = search(num);
			
			if(num == arr[idx])
				sb.append(1 + "\n");
			else
				sb.append(0 + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static int[] arr;
	
	private static int search(int num) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(num <= arr[mid])
				right = mid;
			else
				left = mid + 1;
		}
		
		return right;
	}
}