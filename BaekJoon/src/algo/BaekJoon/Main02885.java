package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main02885 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		Binary = new int[21];
		Binary[0] = 1;
		for(int i = 1; i <= 20; i++)
			Binary[i] = Binary[i - 1] * 2;
		
		int minSize = search();
		int minCnt = splitCnt(minSize);
		
		System.out.println(minSize + " " + minCnt);
	}
	
	private static int K;
	private static int[] Binary;
	
	private static int search() {
		for(int i = 0; i < 21; i++) {
			if(K == Binary[i]) return Binary[i];
			if(K > Binary[i] && K <= Binary[i + 1]) return Binary[i + 1];
		}
		
		return -1;
	}
	
	private static int splitCnt(int minSize) {
		int cnt = 1;
		int num = minSize / 2;
		
		if(K == minSize)
			return 0;
		
		int tmp = num;
		while(K != num) {
			if(K < num + tmp / 2)
				tmp /= 2;
			else {
				tmp /= 2;
				num += tmp;
			}
			cnt++;
		}
		
		return cnt;
	}
}