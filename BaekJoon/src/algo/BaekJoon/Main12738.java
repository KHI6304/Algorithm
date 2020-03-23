package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main12738 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		list.add(-1111111111);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int val = Integer.parseInt(st.nextToken());
			
			if(val > list.get( list.size() - 1 ))
				list.add(val);
			else {
				int idx = binarySearch(val);
				list.set(idx, val);
			}
		}
		
		System.out.println(list.size() - 1);
	}
	
	private static ArrayList<Integer> list;
	
	private static int binarySearch(int val) {
		int left = 0;
		int right = list.size() - 1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(val <= list.get(mid))
				right = mid;
			else
				left = mid + 1;
		}
		
		return right;
	}
}