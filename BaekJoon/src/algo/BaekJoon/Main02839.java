package algo.BaekJoon;

import java.util.Scanner;

/*
	1. 5로 나눠질때까지 계속 해서 3을 빼주면 된다. 또는 3으로 빼가면서 크기가 0보다 같거나 작아지면 종료한다.
	2. 만약 처음값이 0보다 작은 값이면, 5던지 3이던지 나눠질 수 없는 값이다. 그런경우 -1을 출력한다.
*/

public class Main02839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int threeNum = 0, fiveNum = 0;
		
		while(N % 5 != 0 && N >= 0) {
			N -= 3;
			threeNum++;
		}
		
		if(N < 0)
			System.out.println(-1);
		else {
			fiveNum = N / 5;
			System.out.println(threeNum + fiveNum);
		}
	}
}