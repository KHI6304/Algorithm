package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main01082 {
	private static class Num implements Comparable<Num> {
		int n, price;

		public Num(int n, int price) {
			this.n = n;
			this.price = price;
		}

		@Override
		public int compareTo(Num o) {
			if(price == o.price) return -Integer.compare(n, o.n);
			return Integer.compare(price, o.price);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Num[] nums = new Num[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int price = Integer.parseInt(st.nextToken());
			nums[i] = new Num(i, price);
		}
		
		Arrays.sort(nums);
		
		int money = Integer.parseInt(br.readLine());
		
		ArrayList<Num> sol = new ArrayList<>();
		
		if(nums.length != 1 && nums[0].n == 0) {
			if(money < nums[1].price) {
				System.out.println(0);
				return;
			}
			sol.add(nums[1]);
			money -= nums[1].price;
		}
		
		while(money - nums[0].price >= 0) {
			sol.add(nums[0]);
			money -= nums[0].price;
		}
		
		for(int i = 0; i < sol.size(); i++) {
			for(int j = 0; j < nums.length; j++) {
				Num tmp = sol.get(i);
				
				if(tmp.n < nums[j].n && tmp.price + money >= nums[j].price) {
					sol.set(i, nums[j]);
					money += tmp.price - nums[j].price;
				}
			}
		}
		
		for(Num tmp : sol)
			System.out.print(tmp.n);
	}
}