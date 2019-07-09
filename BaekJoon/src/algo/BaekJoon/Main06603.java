package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main06603 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sb = new StringBuilder();
		while(true) {
			String inp = br.readLine();
			if(inp.equals("0")) 
				break;
			
			st = new StringTokenizer(inp);
			int size = Integer.parseInt(st.nextToken());
			int[] arr = new int[size];
			
			for(int i = 0; i < size; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			comb(arr, new int[6], 0, 0);
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static StringBuilder sb;
	static void comb(int[] arr, int[] sel, int idx, int cnt) {
		if(sel.length == cnt) {
			for(int i = 0; i < sel.length; i++)
				sb.append(sel[i]).append(" ");
			sb.append("\n");
			return;
		}
		if(arr.length == idx)
			return;
		
		sel[cnt] = arr[idx];
		comb(arr, sel, idx + 1, cnt + 1);
		sel[cnt] = 0;
		comb(arr, sel, idx + 1, cnt);
	}
}