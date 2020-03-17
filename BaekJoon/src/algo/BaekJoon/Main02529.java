package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main02529 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		inps = br.readLine().split(" ");
		
		visited = new boolean[10];
		list = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			visited[i] = true;
			solve(i, i + "", 0);
			visited[i] = false;
		}
		
		System.out.println(list.get( list.size() - 1 ));
		System.out.println(list.get(0));
	}
	
	private static int k;
	private static String[] inps;
	private static boolean[] visited;
	private static ArrayList<String> list;
	
	private static void solve(int num, String str, int depth) {
		if(depth == k) {
			list.add(str);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(visited[i]) continue;
			
			if(inps[depth].equals("<")) {
				if(num >= i) continue;
			}
			else {
				if(num <= i) continue;
			}
			
			visited[i] = true;
			solve(i, str + i, depth + 1);
			visited[i] = false;
		}
	}
}