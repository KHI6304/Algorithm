package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01011 {
	/*
	 * ó������ ��ͷ� Ǯ���� �õ� �غ�����
	 * �޸� �������� ��Ÿ�� ������ ����.
	 * �׷��� ��Ģ�� ã�� ��,
	 * ���������� Ǫ�� ����� ����ߴ�.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dis = y - x;
			int ans = 0;
			
			int n = 1;
			while(true) {
				int nSquare = (int) Math.pow(n, 2);
				
				if(dis >= nSquare - n + 1 && dis <= nSquare) {
					ans = n * 2 -1;
					break;
				}
				
				if(dis <= nSquare + n) {
					ans = n * 2;
					break;
				}
				
				n++;
			}
			
			System.out.println(ans);
		}
	}
}