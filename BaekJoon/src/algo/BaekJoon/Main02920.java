package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[8];
		boolean asc = true;
		boolean desc = true;
		for(int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i + 1] - arr[i] != 1)
				asc = false;
			if(arr[i + 1] - arr[i] != -1)
				desc = false;
		}
		
		if(asc)
			System.out.println("ascending");
		else if(desc)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}