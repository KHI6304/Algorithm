package algo.BaekJoon;

import java.util.Scanner;

public class Main02960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N + 1];
		for(int i = 2; i <= N; i++)
			arr[i] = 1;
		
		int cnt = 0;
		int sol = 0;
		for(int i = 2; i <= N && cnt != K; i++) {
			if(arr[i] != 0 && cnt != K) {
				int idx = i;
				while(idx <= N && cnt != K) {
					if(arr[idx] != 0) {
						cnt++;
						arr[idx] = 0;
						if(cnt == K)
							sol = idx;
					}
					idx += i;
				}
			}
		}
		System.out.println(sol);
	}
}