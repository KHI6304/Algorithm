package algo.BaekJoon;

import java.util.Scanner;

/*
    1. 문제
	최대 100줄의 입력
	각 줄은 공백으로 시작하지 않고, 공백으로 끝나지 않는다.
	
	2. 풀이
	다음 줄에 입력값이 있는지 어떻게 확인???
	(Scanner 클래스의 hasNextLine() 메소드를 활용)
*/

public class Main11718 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		
		while(sc.hasNextLine()) {
			str = sc.nextLine();
			System.out.println(str);
		}
	}
}