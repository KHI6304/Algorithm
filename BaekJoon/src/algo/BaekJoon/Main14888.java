package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main14888 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		number = new int[N];
		visited = new boolean[N - 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			number[i] = Integer.parseInt(st.nextToken());
		
		op = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			switch (i) {
			case 0:
				for(int j = 0; j < num; j++)
					op.add('+');
				break;
			case 1:
				for(int j = 0; j < num; j++)
					op.add('-');
				break;
			case 2:
				for(int j = 0; j < num; j++)
					op.add('*');
				break;
			case 3:
				for(int j = 0; j < num; j++)
					op.add('/');
				break;
			}
		}
		
		solve(new char[N - 1], 0);
		System.out.println(maxSum);
		System.out.println(minSum);
	}
	
	private static int[] number;
	private static ArrayList<Character> op;
	private static boolean[] visited;
	
	private static int maxSum = Integer.MIN_VALUE;
	private static int minSum = Integer.MAX_VALUE;
	
	private static void solve(char[] opOrder, int depth) {
		if(depth == opOrder.length) {
			int sum = number[0];
			
			for(int i = 0; i < opOrder.length; i++) {
				switch (opOrder[i]) {
				case '+':
					sum += number[i + 1];
					break;
				case '-':
					sum -= number[i + 1];
					break;
				case '*':
					sum *= number[i + 1];
					break;
				case '/':
					if(sum < 0)
						sum = -(Math.abs(sum) / number[i + 1]);
					else
						sum /= number[i + 1];
					break;
				}
			}
			
			maxSum = Math.max(maxSum, sum);
			minSum = Math.min(minSum, sum);
			return;
		}
		
		for(int i = 0; i < op.size(); i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			opOrder[depth] = op.get(i);
			solve(opOrder, depth + 1);
			visited[i] = false;
			opOrder[depth] = 0;
		}
	}
}