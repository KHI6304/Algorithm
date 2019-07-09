package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4050 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			reverseArrayInt(arr);
			
			long sum = 0;
			for(int i = 0; i < N; i += 3) {
				if(i + 1 >= N) {
					sum += arr[i];
					break;
				}
				else if(i + 2 >= N) {
					sum += arr[i] + arr[i + 1];
					break;
				}
				sum += arr[i] + arr[i + 1];
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
	
	static void reverseArrayInt(int[] array) {
	    int temp;

	    for (int i = 0; i < array.length / 2; i++) {
	      temp = array[i];
	      array[i] = array[(array.length - 1) - i];
	      array[(array.length - 1) - i] = temp;
	    }
	  }
}