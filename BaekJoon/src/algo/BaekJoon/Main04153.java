package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main04153 {
	/*
	 * 입력 받은 세수를 배열에 저장한 후,
	 * 정렬을 한다.
	 * 그리고 피타고라스의 정리를 적용한 후,
	 * 직삼각형 유무를 판단한다.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(x == 0 && y == 0 && z == 0)
				break;
			
			int[] arr = new int[3];
			arr[0] = x;
			arr[1] = y;
			arr[2] = z;
			Arrays.sort(arr);
			
			int sol = (int) (Math.pow(arr[2], 2) - Math.pow(arr[0], 2) - Math.pow(arr[1], 2));
			
			if(sol == 0)
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}
}