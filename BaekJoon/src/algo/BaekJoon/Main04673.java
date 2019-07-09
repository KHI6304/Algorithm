package algo.BaekJoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main04673 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = 9900;
		boolean[] arr = new boolean[10001];
		
		for(int i = 1; i < arr.length; i++)
			if(d(i) <= 10000)
				arr[d(i)] = true;
		
		for(int i = 1; i < arr.length; i++)
			if(arr[i] == false)
				bw.write(i + "\n");
		bw.close();
	}
	
	static int d(int n) {
		int res = n;
		
		while(n > 0) {
			res += n % 10;
			n /= 10;
		}
		
		return res;
	}
}