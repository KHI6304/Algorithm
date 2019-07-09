package jungol.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL2247 {
	static class Student implements Comparable<Student>{
		int start;
		int last;
		public Student(int start, int last) {
			this.start = start;
			this.last = last;
		}
		
		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			if(start - o.start == 0)
				return last - o.last;
			return start - o.start;
		}

		@Override
		public String toString() {
			return start + " : " + last;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Student[] sts = new Student[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sts[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(sts);
		
		int existMax = 0;
		int notExistMax = 0;
		for(int i = 0; i < N - 1; i++) {
			if(sts[i].last >= sts[i + 1].start) {
				
				sts[i + 1].start = sts[i].start;
				
				if(sts[i].last > sts[i + 1].last)
					sts[i + 1].last = sts[i].last;
				
				int tmp = sts[i + 1].last - sts[i + 1].start;
				if(existMax < tmp)
					existMax = tmp;
			}
			else {
				int tmp = sts[i + 1].start - sts[i].last;
				if(notExistMax < tmp)
					notExistMax = tmp;
			}
		}
		
		System.out.println(existMax + " " + notExistMax);
	}
}