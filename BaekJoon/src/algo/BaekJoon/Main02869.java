package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02869 {
	/*
	 * �ݺ����� ���� ������ �ð��ʰ��� ���.
	 * �׷��� �������� ������� Ǯ �� �ۿ� ����.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int day = (int) Math.ceil( (double) (V - A) / (double) (A - B) ) + 1;
		
		System.out.println(day);
	}
}