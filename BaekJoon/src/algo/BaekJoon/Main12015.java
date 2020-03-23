package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main12015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		list.add(0);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(list.get(list.size() - 1) < num)
				list.add(num);
			else {
				int idx = binarySearch(num);
				list.set(idx, num);
			}
		}
		
		System.out.println(list.size() - 1);
	}
	
	private static ArrayList<Integer> list;
	
	private static int binarySearch(int num) {
		int left = 0;
		int right = list.size() - 1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(num <= list.get(mid))
				right = mid;
			else
				left = mid + 1;
		}
		
		return right;
	}
}