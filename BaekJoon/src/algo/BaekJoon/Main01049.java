package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int setVal = Integer.MAX_VALUE;
		int unitVal = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int setInp = Integer.parseInt(st.nextToken());
			int unitInp = Integer.parseInt(st.nextToken());
			
			setVal = Math.min(setVal, setInp);
			unitVal = Math.min(unitVal, unitInp);
		}
		
		int setCnt = N / 6;
		int unitCnt = N % 6;
		
		int sol = 0;
		
		sol += Math.min(setVal * setCnt, (unitVal * 6) * setCnt);
		sol += Math.min(setVal, unitVal * unitCnt);
		
		System.out.println(sol);
	}
}