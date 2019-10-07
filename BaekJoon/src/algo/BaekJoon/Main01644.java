package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main01644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		primeNums = new boolean[N + 1];
		primeNums[1] = true;
		list = new ArrayList<>();
		
		solve();
		for(int i = 1; i <= N; i++)
			if(!primeNums[i])
				list.add(i);
		
		cnt = 0;
		twoPointers();
		System.out.println(cnt);
	}
	
	private static int N;
	private static boolean[] primeNums;
	private static List<Integer> list;
	private static int cnt;
	
	private static void solve() {
		for(int i = 2; i <= N; i++) {
			for(int j = 2; i * j <= N; j++) {
				primeNums[i * j] = true;
			}
		}
	}
	
	private static void twoPointers() {
		int start = 0, end = 0, sum = 0;
		
		while(true) {
			if(sum >= N)
				sum -= list.get(start++);
			else if(end == list.size())
				break;
			else
				sum += list.get(end++);
			
			if(sum == N)
				cnt++;
		}
	}
}