package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15658 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		ops = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++)
			ops[i] = Integer.parseInt(st.nextToken());
		
		solve(nums[0], 1);
		
		System.out.println(maxSol);
		System.out.println(minSol);
	}
	
	private static int N;
	private static int[] nums;
	private static int[] ops;
	
	private static int maxSol = Integer.MIN_VALUE;
	private static int minSol = Integer.MAX_VALUE;
	
	private static void solve(int sum, int depth) {
		if(depth == N) {
			maxSol = Math.max(maxSol, sum);
			minSol = Math.min(minSol, sum);
			
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(ops[i] == 0) continue;
			
			ops[i]--;
			switch (i) {
			case 0:
				solve(sum + nums[depth], depth + 1);
				break;
			case 1:
				solve(sum - nums[depth], depth + 1);
				break;
			case 2:
				solve(sum * nums[depth], depth + 1);
				break;
			case 3:
				solve(sum / nums[depth], depth + 1);
				break;
			}
			ops[i]++;
		}
	}
}