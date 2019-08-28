package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = {0, 0, 0};
		int sol = 0;
		
		while(true) {
			for(int i = 0; i < arr.length; i++)
				arr[i] += 1;
			sol++;
			
			if( arr[0] % 16 == 0 )
				arr[0] = 1;
			if( arr[1] % 29 == 0 )
				arr[1] = 1;
			if( arr[2] % 20 == 0 )
				arr[2] = 1;
			
			if(arr[0] == E && arr[1] == S && arr[2] == M)
				break;
		}
		
		System.out.println(sol);
	}
}