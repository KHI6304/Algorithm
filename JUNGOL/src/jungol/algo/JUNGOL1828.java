package jungol.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL1828 {
	static class Refrigeator implements Comparable<Refrigeator> {
		int lowest;
		int highest;
		
		public Refrigeator(int lowest, int highest) {
			this.lowest = lowest;
			this.highest = highest;
		}

		@Override
		public int compareTo(Refrigeator o) {
			return lowest - o.lowest;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Refrigeator[] rfs = new Refrigeator[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			rfs[i] = new Refrigeator(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(rfs);
		
		int sol = 1;
		int h = rfs[0].highest;
		for(int i = 1; i < rfs.length; i++) {
			if(h >= rfs[i].lowest) {
				if(h > rfs[i].highest)
					h = rfs[i].highest;
			}
			else {
				sol++;
				h = rfs[i].highest;
			}
		}
		
		System.out.println(sol);
	}
}