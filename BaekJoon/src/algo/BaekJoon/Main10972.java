package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10972 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		
		if(N == 1) {
			System.out.println(-1);
			return;
		}
		
		for(idx = arr.length - 1; idx > 0; idx--) {
			if(arr[idx - 1] < arr[idx]) {
				
				for(int i = arr.length - 1; i > idx - 1; i--) {
					if(arr[idx - 1] < arr[i]) {
						int tmp = arr[i];
						arr[i] = arr[idx - 1];
						arr[idx - 1] = tmp;
						break;
					}
				}
				
				desc(arr, idx);
				break;
			}
			
			if(idx == 1) {
				System.out.println(-1);
				return;
			}
		}
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	private static void desc(int[] arr, int start) {
		for(int i = start; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
}