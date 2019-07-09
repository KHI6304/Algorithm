package algo.BaekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main02231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int len = (int)(Math.log10(N) + 1);
		List<Integer> sol = new ArrayList<>();
		
		for(int i = N; i >= 1; i--) {
			int sum = i;
			int tmp = i;
			for(int j = 0; j < len; j++) {
				sum += tmp % 10;
				tmp /= 10;
			}
			if(N == sum)
				sol.add(i);
		}
		if(sol.size() == 0)
			System.out.println(0);
		else
			System.out.println(sol.get(sol.size() - 1));
	}
}