package Chap21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TRAVERSAL {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] preorder = new int[N];
			int[] inorder = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				preorder[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				inorder[i] = Integer.parseInt(st.nextToken());
			
			printPostOrder(preorder, inorder);
			System.out.println();
		}
	}
	
	static int[] slice(int[] arr, int a, int b) {
		int[] tmp = Arrays.copyOfRange(arr, a, b);
		return tmp;
	}
	
	static void printPostOrder(int[] preorder, int[] inorder) {
		int N = preorder.length;
		if( N == 0 ) return;
		
		int root = preorder[0];
		
		int idx = 0;
		for(int i = 0; i < inorder.length; i++) {
			if(inorder[i] == root) {
				idx = i;
				break;
			}
		}
		
		int L = idx;
		
		printPostOrder(slice(preorder, 1, L + 1), slice(inorder, 0, L));
		printPostOrder(slice(preorder, L + 1, N), slice(inorder, L + 1, N));
		System.out.print(root + " ");
	}
}