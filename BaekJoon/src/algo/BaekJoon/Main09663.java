package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main09663 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		ans = 0;
		
		nQueen(new int[N], 0);
		
		System.out.println(ans);
	}
	
	private static int N;
	private static int ans;
	
	private static boolean isOk(int ax, int ay, int bx, int by) {
		if(ay == by) return false;
		
		if( Math.abs(ax - bx) == Math.abs(ay - by) ) return false;
		
		return true;
	}
	
	private static void nQueen(int[] arr, int depth) {
		if(depth == N) {
			ans++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(depth == 0) {
				arr[depth] = i;
				nQueen(arr, depth + 1);
			}
			else {
				boolean flag = true;
				
				for(int j = 0; j < depth && flag; j++)
					if(!isOk(j, arr[j], depth, i))
						flag = false;
				
				if(flag) {
					arr[depth] = i;
					nQueen(arr, depth + 1);
				}
			}
		}
	}
}