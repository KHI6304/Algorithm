package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main15649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		int[] arr = new int[N];
		for(int i = 1; i <= N; i++)
			arr[i - 1] = i;
		
		perm(arr, 0);
		
		Collections.sort(list);
		for(int i : list)
			System.out.println(i);
	}
	
	private static List<Integer> list;
	
	private static void perm(int[] arr, int idx) {
		if(arr.length == idx) {
			int num = 0;
			for(int i = 0; i < arr.length; i++)
				num += (int) Math.pow(10, arr.length - i - 1) * arr[i];
			list.add(num);
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			swap(arr, i, idx);
			perm(arr, idx + 1);
			swap(arr, i, idx);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}