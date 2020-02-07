package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main02941 {
	
	/*
	 * 크로아티아 알파벳을 
	 * '*'이라는 하나의 문자로 치환.
	 * 그리고 마지막에 해당 문자열의 길이를 출력한다.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] croAlp = {
			"dz=",
			"c=",
			"c-",
			"d-",
			"lj",
			"nj",
			"s=",
			"z="
		};
		
		String inp = br.readLine();
		
		for(int i = 0; i < croAlp.length; i++)
			inp = inp.replaceAll(croAlp[i], "*");
		
		System.out.println(inp.length());
	}
}