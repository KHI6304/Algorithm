package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main02036 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> pos = new PriorityQueue<>();
		PriorityQueue<Long> neg = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			long num = Integer.parseInt(br.readLine());
			
			if(num > 0) pos.add(-num);
			else neg.add(num);
		}
		
		long sol = 0;
		
		while(!pos.isEmpty()) {
			long num = -pos.poll();
			
			if(num == 1)
				sol++;
			else if(!pos.isEmpty()) {
				long num2 = -pos.poll();
				
				if(num2 == 1)
					sol += num + num2;
				else
					sol += num * num2;
			}
			else
				sol += num;
		}
		
		while(!neg.isEmpty()) {
			long num = neg.poll();
			
			if(!neg.isEmpty())
				sol += num * neg.poll();
			else
				sol += num;
		}
		
		System.out.println(sol);
	}
}