package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01991 {
	static class Node {
		String data;
		String left;
		String right;
		
		public Node(String data, String left, String right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		nodes = new Node[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nodes[i] = new Node(st.nextToken(), st.nextToken(), st.nextToken());
		}
		
		preorder(nodes[0]);
		inorder(nodes[0]);
		postorder(nodes[0]);
		
		System.out.println(preorderSB.toString());
		System.out.println(inorderSB.toString());
		System.out.println(postorderSB.toString());
	}
	
	static Node[] nodes;
	static StringBuffer preorderSB = new StringBuffer();
	static StringBuffer inorderSB = new StringBuffer();
	static StringBuffer postorderSB = new StringBuffer();
	
	static int search(String data) {
		int idx = 0;
		for(int i = 0; i < nodes.length; i++) {
			if(data.equals(nodes[i].data)) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	
	static void preorder(Node node) {
		preorderSB.append(node.data);
		if( !node.left.equals(".") ) {
			int idx = search(node.left);
			preorder(nodes[idx]);
		}
		if( !node.right.equals(".") ) {
			int idx = search(node.right);
			preorder(nodes[idx]);
		}
	}
	
	static void inorder(Node node) {
		if( !node.left.equals(".") ) {
			int idx = search(node.left);
			inorder(nodes[idx]);
		}
		inorderSB.append(node.data);
		if( !node.right.equals(".") ) {
			int idx = search(node.right);
			inorder(nodes[idx]);
		}
	}
	
	static void postorder(Node node) {
		if( !node.left.equals(".") ) {
			int idx = search(node.left);
			postorder(nodes[idx]);
		}
		if( !node.right.equals(".") ) {
			int idx = search(node.right);
			postorder(nodes[idx]);
		}
		postorderSB.append(node.data);
	}
}