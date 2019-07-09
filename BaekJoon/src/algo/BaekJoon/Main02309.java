package algo.BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main02309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] Dwarf = new int[9];
		int[] RealDwarf = new int[7];
		
		for(int i = 0; i < 9; i++)
			Dwarf[i] = sc.nextInt();
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				int sum = 0;
				if(i == j)
					continue;
				
				for(int k = 0; k < 9; k++)
					if(k != i && k != j)
						sum += Dwarf[k];	
				if(sum == 100) {
					int cnt = -1;
					for(int k = 0; k < 9; k++)
						if(k != i && k != j)
							RealDwarf[++cnt] = Dwarf[k]; 
				}
			}
		}
		Arrays.sort(RealDwarf);
		
		for(int a : RealDwarf)
			System.out.println(a);
	}
}