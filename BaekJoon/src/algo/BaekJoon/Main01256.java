package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main01256 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int Z = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[] dic = new char[A + Z];
		for(int i = 0; i < A; i++)
			dic[i] = 'a';
		for(int i = A; i < dic.length; i++)
			dic[i] = 'z';
		
		perm(dic, 0);
	}
	
	static HashSet<char[]> set = new HashSet<>();
	
	static void perm(char[] arr, int idx) {
		if(arr.length == idx) {
			int size = set.size();
			set.add(arr);
			
			if(size != set.size()) {
				for(int i = 0; i < arr.length; i++)
					System.out.print(arr[i] + " ");
				System.out.println();
			}
			
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			swap(arr, idx, i);
			perm(arr, idx + 1);
			swap(arr, idx, i);
		}
	}
	
	static void swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}