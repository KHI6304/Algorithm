package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inp = br.readLine().split("-");
		
		int sum = calc(inp[0]);
		for(int i = 1; i < inp.length; i++)
			sum -= calc(inp[i]);
		
		System.out.println(sum);
	}
	
	private static int calc(String str) {
		String[] arr = str.split("\\+");
		
		int sum = 0;
		for(String num : arr)
			sum += Integer.parseInt(num);
		
		return sum;
	}
}