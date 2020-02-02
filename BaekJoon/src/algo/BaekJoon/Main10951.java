package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10951 {
	/*
	 * ��Ŭ���� �󿡼��� ������ ������
	 * ������ ä���� �غ���
	 * ������ �ȴ�.
	 * 
	 * EOF�� ó���ϴ� ����� �Է� Ŭ���� 2���� ��η� �ذ��� �� �ִ�.
	 * 
	 * Scanner Ŭ������
	 * hasNextLine()�� hasNextInt() �޼ҵ带
	 * ����Ͽ� �ذ��� �� �ִ�.
	 * 
	 * ��Ȥ StringTokenizer�� EOF�� ó���ϴ� �õ��� �� �� �ִ�.
	 * ����� �޼ҵ��� hasMoreTokens�� ����� ���� ������ �� �ִ�.
	 * StringTokenizer�� ���ڿ��� �Է��ϴ� ���� �ƴ� �Է� ���� ���ڿ��� �����ϴ� ������ �Ѵ�.
	 * �ܼ��� ������ ���ڿ� ��ü���� ���ϴ� ������ �ϱ� ������ EOF�� ó���Ѵٰ� ����� ��ƴ�.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String inp = "";
		while( (inp = br.readLine()) != null ) {
			st = new StringTokenizer(inp);
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			System.out.println(A + B);
		}
	}
}