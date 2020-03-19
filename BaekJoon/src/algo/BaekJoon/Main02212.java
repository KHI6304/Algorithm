package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main02212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> sensor = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int pos = Integer.parseInt(st.nextToken());
			
			if(!sensor.contains(pos))
				sensor.add(pos);
		}
		
		Collections.sort(sensor);
		
		int sum = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < sensor.size() - 1; i++) {
			int distance = sensor.get(i + 1) - sensor.get(i);
			sum += distance;
			
			q.add(distance);
		}
		
		if(N <= K) {
			System.out.println(0);
			return;
		}
		
		for(int i = 0; i < K - 1; i++)
			sum -= q.poll();
		
		System.out.println(sum);
	}
}