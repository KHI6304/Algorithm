package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main02141 {
	private static class City implements Comparable<City> {
		int pos, num;

		public City(int pos, int num) {
			this.pos = pos;
			this.num = num;
		}

		@Override
		public int compareTo(City c) {
			return Integer.compare(pos, c.pos);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		long sum = 0;
		City[] cities = new City[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			sum += num;
			cities[i] = new City(pos, num);
		}
		
		Arrays.sort(cities);
		
		int idx = 0;
		long partSum = 0;
		for(idx = 0; idx < N; idx++) {
			partSum += cities[idx].num;
			
			if(partSum >= sum - partSum)
				break;
		}
		
		System.out.println(cities[idx].pos);
	}
}