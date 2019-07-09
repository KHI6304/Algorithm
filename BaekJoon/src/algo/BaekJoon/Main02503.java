package algo.BaekJoon;

import java.util.Scanner;

public class Main02503 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String[] inp = new String[N];
		int[] strikeArr = new int[N];
		int[] ballArr = new int[N];
		int cnt = 0;
		
		
		for(int i = 0; i < N; i++) {
			inp[i] = sc.next();
			strikeArr[i] = sc.nextInt();
			ballArr[i] = sc.nextInt();
		}
		
		for(int a = 1; a < 10; a++) {
			for(int b = 1; b < 10; b++) {
				if(b == a)
					continue;
				for(int c = 1; c < 10; c++) {
					if(c == a || c == b)
						continue;
					String num = a + "" + b + c;
					boolean flag = true;
					
					for(int i = 0; i < N; i++) {
						int strike = 0;
						int ball = 0;
						if(num.charAt(0) == inp[i].charAt(1)) ball++;
						if(num.charAt(0) == inp[i].charAt(2)) ball++;
						if(num.charAt(1) == inp[i].charAt(0)) ball++;
						if(num.charAt(1) == inp[i].charAt(2)) ball++;
						if(num.charAt(2) == inp[i].charAt(0)) ball++;
						if(num.charAt(2) == inp[i].charAt(1)) ball++;
						
						if(num.charAt(0) == inp[i].charAt(0)) strike++;
						if(num.charAt(1) == inp[i].charAt(1)) strike++;
						if(num.charAt(2) == inp[i].charAt(2)) strike++;
						
						if(strikeArr[i] != strike || ballArr[i] != ball) {
							flag = false;
							break;
						}
					}
					if(flag) cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}