package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main10448 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = new ArrayList<>();
		
		int n = 1;
		while( n * (n + 1) / 2 < 1000 ) {
			T.add(n * (n + 1) / 2);
			n++;
		}
		
		int tc = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < tc; testCase++) {
			K = Integer.parseInt(br.readLine());
			ans = 0;
			
			Eureka(0, 0);
			
			System.out.println(ans);
		}
	}
	
	private static ArrayList<Integer> T;
	private static int K;
	private static int ans;
	
	private static void Eureka(int sum, int depth) {
		if(depth == 3) {
			if(sum == K)
				ans = 1;
			return;
		}
		if(ans == 1)
			return;
		
		for(int i = 0; i < T.size(); i++)
			Eureka(sum + T.get(i), depth + 1);
	}
}