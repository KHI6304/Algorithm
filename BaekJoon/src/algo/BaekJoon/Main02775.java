package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main02775 {
	/*
	 * ��ͷ� Ǫ�� ����� ������ �迭���ٰ� ���� �����ϴ� �ܼ� �ݺ����� Ǫ�� ����� �ִ�.
	 * �ڵ��� �������� ��ͷ� Ǫ�� ���� ������ ������,
	 * �ӵ��鿡���� ���ڿ� 5�� ���� ���̰� ����.
	 * �̸� ���� ��ʹ� �ӵ� �鿡�� ���� ���ذ� ����ٴ� ���� �� �� �־���.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			
			System.out.println(solve(k, n));
		}
	}
	
	private static int solve(int k, int n) {
		if(n == 0)
			return 0;
		else if(k == 0)
			return n;
		else
			return solve(k, n - 1) + solve(k - 1, n);
	}
}