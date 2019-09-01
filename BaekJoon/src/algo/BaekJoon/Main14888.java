package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		// 0 : + , 1 : - , 2 : × , 3 : ÷
		int[] opCnt = new int[4];
		char[] op = new char[N - 1];
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for(int i = 0; i < 4; i++) {
			opCnt[i] = Integer.parseInt(st.nextToken());
			for(int j = 0; j < opCnt[i]; j++) {
				switch(i) {
				case 0:
					op[idx++] = '+';
					break;
				case 1:
					op[idx++] = '-';
					break;
				case 2:
					op[idx++] = '*';
					break;
				case 3:
					op[idx++] = '/';
					break;
				}
			}
		}
		
		perm(op, 0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static int[] arr;
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	
	private static void perm(char[] op, int idx) {
		if(op.length == idx) {
			int sum = arr[0];
			
			for(int i = 0; i < op.length; i++) {
				switch(op[i]) {
				case '+' :
					sum += arr[i + 1];
					break;
				case '-' :
					sum -= arr[i + 1];
					break;
				case '*' :
					sum *= arr[i + 1];
					break;
				case '/' :
					if(sum < 0) {
						sum = -sum;
						sum /= arr[i + 1];
						sum = -sum;
					}
					else {
						sum /= arr[i + 1];
					}
					break;
				}
			}
			
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			
			return;
		}
		
		for(int i = idx; i < op.length; i++) {
			swap(op, i, idx);
			perm(op, idx + 1);
			swap(op, i, idx);
		}
	}
	
	private static void swap(char[] op, int i, int j) {
		char tmp = op[i];
		op[i] = op[j];
		op[j] = tmp;
	}
}