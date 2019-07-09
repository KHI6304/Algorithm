package com.ex;

public class powBottomUp {
	public static void main(String[] args) {
		power(2, 20);
	}
	
	static void power(int a, int n) {
		// n의 log값(밑2)를 구한다. -> cnt
		// cnt + 1 크기의 배열을 생성한다.
		// 0번 칸에는 밑인 a, 1번칸부턴 앞에칸의 수를 거듭제곱해 저장하여 각 1, 2, 4, 8, 16... 승이 저장되게 배열을 채운다.
		// n을 비트마스킹하며 필요하면서 자릿수를 곱해간다. ( ex. 9 == 8승 * 1승)
		
		int k = n;
		int cnt = 0;
		while( k != 1) {
			k /= 2;
			cnt++;
		}
		long[] powMap = new long[cnt + 1];
		powMap[0] = a;
		for(int i = 1; i < powMap.length; i++)
			powMap[i] = powMap[i - 1] * powMap[i - 1];
		
		long result = 1;
		for(int i = 0; i < cnt + 1; i++)
			// 1을 i만큼 << 한 아이와 n을 & 연산해서 0이 아니면 해당 인덱스의 값을 누적곱
			if( (n & (1 << i)) != 0)
				result *= powMap[i];
		
		System.out.println(result);
	}
}