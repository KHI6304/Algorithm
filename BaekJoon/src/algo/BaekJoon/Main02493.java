package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main02493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer nums = new StringTokenizer(str);
		int count = 0;
		
		while(nums.hasMoreTokens()) {
			count++;
			int num = Integer.parseInt(nums.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek() < num) {
					stack.pop();
					index.pop();
				}
				
				if(stack.isEmpty())
					break;
				
				if(stack.peek() > num) {
					stack.push(num);
					sb.append(index.peek() + " ");
					index.push(count);
					break;
				}
			}
			if(stack.isEmpty()) {
				stack.push(num);
				index.push(count);
				sb.append("0 ");
			}
		}
		
		bw.write(sb.toString());
		bw.close();
	}
}