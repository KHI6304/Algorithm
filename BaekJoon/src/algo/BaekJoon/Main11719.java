package algo.BaekJoon;

import java.util.Scanner;

/*
1. 문제
최대 100줄의 입력 (알파벳 소문자, 대문자, 숫자, 공백)
각 줄의 앞 뒤에 공백이 있을 수도 있다.
빈 줄이 주어질 수도 있다.

2. 풀이
다음 줄에 입력값이 있는지 어떻게 확인???
(Scanner 클래스의 hasNextLine() 메소드를 활용)
*/

public class Main11719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		
		while(sc.hasNextLine()) {
			str = sc.nextLine();
			System.out.println(str);
		}
	}
}