package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10974 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		for(int i = 0; i < N; i++)
			arr[i] = i + 1;
		
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			perm(arr, visited, new int[N], i, 0);
			visited[i] = false;
		}
	}
	
	private static void perm(int[] arr, boolean[] visited, int[] output, int start, int depth) {
		output[depth] = start + 1;
		
		if(depth == output.length - 1) {
			print(output);
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			perm(arr, visited, output, i, depth + 1);
			visited[i] = false;
		}
	}
	
	private static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}