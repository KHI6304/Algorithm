package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10951 {
	/*
	 * 이클립스 상에서는 에러가 뜨지만
	 * 실제로 채점을 해보면
	 * 정답이 된다.
	 * 
	 * EOF를 처리하는 방법은 입력 클래스 2가지 모두로 해결할 수 있다.
	 * 
	 * Scanner 클래스는
	 * hasNextLine()나 hasNextInt() 메소드를
	 * 사용하여 해결할 수 있다.
	 * 
	 * 간혹 StringTokenizer로 EOF를 처리하는 시도를 볼 수 있다.
	 * 비슷한 메소드인 hasMoreTokens의 존재로 인해 오해할 수 있다.
	 * StringTokenizer는 문자열을 입력하는 것이 아닌 입력 받은 문자열을 가공하는 역할을 한다.
	 * 단순히 가공한 문자열 자체에서 원하는 행위를 하기 때문에 EOF를 처리한다고 보기는 어렵다.
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