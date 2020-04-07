package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main01062 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 5;
		
		int preChk = 0;
		strList = new ArrayList<>();
		charSet = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			str = str.replaceAll("[acnit]", "");
			
			if(str.length() == 0)
				preChk++;
			else {
				strList.add(str);
				
				for(int j = 0; j < str.length(); j++)
					if(!charSet.contains(str.charAt(j)))
						charSet.add(str.charAt(j));
			}
		}
		
		if(K < 0) {
			System.out.println(0);
			return;
		}
		
		sol = 0;
		DFS(new boolean[charSet.size()], 0, 0);
		System.out.println(sol + preChk);
	}
	
	private static int sol;
	private static int N, K;
	private static ArrayList<String> strList;
	private static ArrayList<Character> charSet;
	
	private static void DFS(boolean[] visited, int idx, int depth) {
		if(K == depth || visited.length == depth) {
			int cnt = 0;
			for(int i = 0; i < strList.size(); i++) {
				String str = strList.get(i);
				
				for(int j = 0; j < str.length(); j++) {
					char c = str.charAt(j);
					int charIdx = charSet.indexOf(c);
					
					if(!visited[charIdx])
						break;
					
					if(j == str.length() - 1)
						cnt++;
				}
			}
			
			sol = Math.max(sol, cnt);
			return;
		}
		
		for(int i = idx; i < charSet.size(); i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			DFS(visited, i + 1, depth + 1);
			visited[i] = false;
		}
	}
}