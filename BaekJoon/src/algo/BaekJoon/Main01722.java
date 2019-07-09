package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main01722 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 1; i <= N; i++)
			arr[i - 1] = i;
		list = new ArrayList<>();
		perm(arr, 0);
		Collections.sort(list);
		
		st = new StringTokenizer(br.readLine());
		int sel = Integer.parseInt(st.nextToken());
		int k = 0;
		int[] tmp = new int[N];
		if(sel == 1) {
			k = Integer.parseInt(st.nextToken());
			String output = String.valueOf(list.get(k - 1));
			for(int i = 0; i < output.length(); i++)
				System.out.print(output.charAt(i) + " ");
		}
		else {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++)
				sb.append(st.nextToken());
			int inp = Integer.parseInt(sb.toString());
			System.out.println(list.indexOf(inp) + 1);
		}
			
	}
	
	static List<Integer> list = null;
	static void perm(int[] arr, int idx) {
		if(idx == arr.length) {
			int sum = 0;
			for(int i = 0; i < arr.length; i++)
				sum = sum * 10 + arr[i];
			list.add(sum);
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			swap(arr, idx, i);
			perm(arr, idx + 1);
			swap(arr, idx, i);
		}
	}
	
	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}