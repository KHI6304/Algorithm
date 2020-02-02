package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main05622 {
	/*
	 * 1과 0을 제외한 다이얼의 숫자에는
	 * 해당하는 문자열이 있다.
	 * 
	 * 우선 해당하는 문자열을 문자열 배열에 순차적으로 저장한다.
	 * 그리고 입력 받은 문자열을 캐릭터 배열에 저장을 한다.
	 * 
	 * 정답인 sol 값에 캐릭터 배열의 크기 * 2를 초기값으로 선언한다.
	 * 모든 캐릭터 배열의 값을 돌면서 1과 떨어진 만큼 sol 값에 더해주면 정답이 나온다.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] inp = br.readLine().toCharArray();
		
		String[] dial = {
				"",
				"ABC",
				"DEF",
				"GHI",
				"JKL",
				"MNO",
				"PQRS",
				"TUV",
				"WXYZ"
		};
		
		int sol = inp.length * 2;
		for(int i = 0; i < inp.length; i++) {
			for(int j = 1; j < dial.length; j++) {
				if(dial[j].contains(inp[i] + "")) {
					sol += j;
					break;
				}
			}
		}
		
		System.out.println(sol);
	}
}