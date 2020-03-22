package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sum = new int[N];
		
		int sol = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			sum[i] = arr[i] = Integer.parseInt(st.nextToken());
			
			int tmpSum = 0;
			for(int j = 0; j < i; j++)
				if(arr[i] > arr[j])
					tmpSum = Math.max(tmpSum, sum[j]);
			
			sum[i] += tmpSum;
			sol = Math.max(sol, sum[i]);
		}
		
		System.out.println(sol);
	}
}