package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main01406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		LinkedList<Character> str = new LinkedList<>();
		String tmp = br.readLine();
		for(int i = 0; i < tmp.length(); i++)
			str.add(tmp.charAt(i));
		
		int N = Integer.parseInt(br.readLine());
		int cursor = str.size();
		int len = str.size();
		
		for(int repeat = 0; repeat < N; repeat++) {
			st = new StringTokenizer(br.readLine());
			
			char command = st.nextToken().charAt(0);
			
			switch(command) {
			case 'L' :
				if(cursor == 0)
					break;
				cursor--;
				break;
			case 'D' :
				if(cursor + 1 > len)
					break;
				cursor++;
				break;
			case 'B' :
				if(cursor == 0)
					break;
				str.remove(--cursor);
				len--;
				break;
			case 'P' :
				char c = st.nextToken().charAt(0);
				if(cursor == len)
					str.add(c);
				else
					str.add(cursor, c);
				len++;
				cursor++;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.size(); i++)
			sb.append(str.get(i));
		System.out.println(sb.toString());
	}
}