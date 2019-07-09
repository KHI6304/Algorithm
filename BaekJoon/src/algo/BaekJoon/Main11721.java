package algo.BaekJoon;

import java.util.Scanner;

public class Main11721 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		
		for(int i = 1; i < inp.length() + 1; i++) {
			System.out.print(inp.charAt(i - 1));
			if(i % 10 == 0)
				System.out.println();
		}
	}
}