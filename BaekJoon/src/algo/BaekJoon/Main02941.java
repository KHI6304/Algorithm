package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main02941 {
	
	/*
	 * ũ�ξ�Ƽ�� ���ĺ��� 
	 * '*'�̶�� �ϳ��� ���ڷ� ġȯ.
	 * �׸��� �������� �ش� ���ڿ��� ���̸� ����Ѵ�.
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