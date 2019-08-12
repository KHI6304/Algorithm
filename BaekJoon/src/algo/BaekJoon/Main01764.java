package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main01764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<String> list1 = new ArrayList<>();
		for(int i = 0; i < N; i++)
			list1.add(br.readLine());
		
		Collections.sort(list1);
		String[] tmp = new String[ list1.size() ];
		tmp = list1.toArray(tmp);
		
		List<String> list2 = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			int idx = Arrays.binarySearch(tmp, s);
			if(idx >= 0)
				list2.add(s);
		}
		
		Collections.sort(list2);
		System.out.println(list2.size());
		for(String s : list2)
			System.out.println(s);
	}
}