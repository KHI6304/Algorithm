package Chap06;

public class Recursion01 {
	public static void main(String[] args) {
		System.out.println(recurSum(10));
	}
	
	static int recurSum(int n) {
		if( n == 1 ) return 1;
		return n + recurSum(n - 1);
	}
}