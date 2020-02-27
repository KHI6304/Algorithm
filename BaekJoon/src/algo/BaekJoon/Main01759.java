package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main01759 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		inp = new String[C];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++)
			inp[i] = st.nextToken();
		
		Arrays.sort(inp);
		
		sb = new StringBuilder();
		solve(new int[L], 0, 0);
		System.out.println(sb);
	}
	
	private static int L;	// 암호 길이
	private static int C;	// 전체 문자 개수
	private static String[] inp;
	private static StringBuilder sb;
	
	private static void solve(int[] arr, int idx, int depth) {
		if(depth == L) {
			int consonant;	// 자음
			int vowel = 0;  // 모음
			
			for(int i : arr)
				if(inp[i].equals("a") || inp[i].equals("e") || inp[i].equals("i") || inp[i].equals("o") || inp[i].equals("u")) vowel++;
			
			consonant = L - vowel;
			
			if(consonant < 2 || vowel == 0) return;
			
			for(int i : arr)
				sb.append(inp[i]);
			sb.append("\n");
			
			return;
		}
		
		for(int i = idx; i < inp.length; i++) {
			arr[depth] = i;
			solve(arr, i + 1, depth + 1);
		}
	}
}