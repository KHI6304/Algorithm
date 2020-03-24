package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main14003 {
	private static class Node {
		int idx, val;

		public Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] beforeIdx = new int[N];
		
		list = new ArrayList<>();
		list.add(new Node(-1, Integer.MIN_VALUE));
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int size = list.size() - 1;
			
			if(arr[i] > list.get(size).val) {
				beforeIdx[i] = list.get(size).idx;
				list.add(new Node(i, arr[i]));
			}
			else {
				int idx = binarySearch(arr[i]);
				list.set(idx, new Node(i, arr[i]));
				beforeIdx[i] = list.get(idx - 1).idx;
			}
		}
		
		int size = list.size() - 1;
		System.out.println(size);
		
		Stack<Integer> s = new Stack<>();
		int idx = list.get(size).idx;
		while(idx != -1) {
			s.push(arr[idx]);
			idx = beforeIdx[idx];
		}
		
		while(!s.isEmpty())
			System.out.print(s.pop() + " ");
	}
	
	private static ArrayList<Node> list;
	
	private static int binarySearch(int val) {
		int left = 0;
		int right = list.size() - 1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(val <= list.get(mid).val)
				right = mid;
			else
				left = mid + 1;
		}
		
		return right;
	}
}