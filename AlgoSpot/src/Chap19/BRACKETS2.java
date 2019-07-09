package Chap19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BRACKETS2 {
	static String opening = "({[";
	static String closing = ")}]";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			Stack<Character> s = new Stack<>();
			char[] arr = br.readLine().toCharArray();
			
			boolean flag = true;
			for(char c : arr) {
				if(!flag)
					break;
				if(opening.contains(c + ""))
					s.push(c);
				else {
					if(s.isEmpty()) {
						flag = false;
						break;
					}
					if( opening.indexOf(s.pop()) != closing.indexOf(c) )
						flag = false;
				}
			}
			
			if(!s.isEmpty())
				flag = false;
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}