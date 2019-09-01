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
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[] arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++)
			arr[i] = st.nextToken().charAt(0);
		
		if(L == C) {
			Arrays.sort(arr);
			for(int i = 0; i < arr.length; i++)
				System.out.print(arr[i]);
			return;
		}
		
		comb(arr, new char[L], 0, 0);
	}
	
	private static void comb(char[] arr, char[] sel, int idx, int cnt) {
		if(sel.length == cnt) {
			int jCnt = 0;
			int mCnt = 0;
			char[] tmp = new char[4];
			
			for(int i = 0; i < sel.length; i++) {
				tmp[i] = sel[i];
				if(isMoUm( sel[i] ))
					mCnt++;
				else
					jCnt++;
			}
			
			Arrays.sort(tmp);
			
			if(jCnt < 2 || mCnt < 1)
				return;
			
			for(int i = 0; i < tmp.length; i++)
				System.out.print(tmp[i]);
			System.out.println();
			
			return;
		}
		
		if(arr.length == idx)
			return;
		
		sel[cnt] = arr[idx];
		comb(arr, sel, idx + 1, cnt + 1);
		comb(arr, sel, idx + 1, cnt);
	}
	
	private static boolean isMoUm(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		return false;
	}
}