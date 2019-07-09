package Chap07;

public class fastSum {
	public static void main(String[] args) {
		System.out.println(fSum(10));
	}
	
	static int fSum(int n) {
		if( n == 1 ) return 1;	// 기저 사례
		if( n % 2 == 1 ) return n + fSum(n - 1);	// 만약 n이 홀수 인 경우
		
		return 2 * fSum(n / 2) + (n / 2) * (n / 2);
	}
}
