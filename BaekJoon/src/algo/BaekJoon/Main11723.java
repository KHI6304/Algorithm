package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		M = Integer.parseInt(br.readLine());
		arr = new boolean[21];
		for(int i = 0; i < M; i++) {
			String inp = br.readLine();
			
			if(inp.contains("all") || inp.contains("empty")) {
				calc(inp, 0);
				continue;
			}
			
			st = new StringTokenizer(inp);
			calc(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(sb);
	}
	
	private static int M;
	private static boolean[] arr;
	private static StringBuilder sb = new StringBuilder();
	
	private static void calc(String op, int x) {
		switch (op) {
		case "add":
			arr[x] = true;
			break;
		case "remove":
			arr[x] = false;
			break;
		case "check":
			if(arr[x])
				sb.append("1\n");
			else
				sb.append("0\n");
			break;
		case "toggle":
			arr[x] = !arr[x];
			break;
		case "all":
			for(int i = 1; i <= 20; i++)
				arr[i] = true;
			break;
		case "empty":
			for(int i = 1; i <= 20; i++)
				arr[i] = false;
			break;
		}
	}
}