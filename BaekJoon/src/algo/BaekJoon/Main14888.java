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
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		// 덧셈, 뺄셈, 곱셈, 나눗셈
		int[] cntOper = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++)
			cntOper[i] = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		char[] opers = new char[N - 1];
		for(int i = 0; i < 4; i++) {
			while(cntOper[i] != 0) {
				
				switch(i) {
				case 0 :
					opers[idx++] = '+';
					break;
				case 1 :
					opers[idx++] = '-';
					break;
				case 2 :
					opers[idx++] = '*';
					break;
				case 3 :
					opers[idx++] = '/';
					break;
				}
				
				cntOper[i]--;
			}
		}
		
		min = Integer.MAX_VALUE;
		max = -Integer.MAX_VALUE;
		
		perm(opers, 0);
		System.out.println(max);
		System.out.println(min);
	}
	
	static long min;
	static long max;
	static int[] nums;
	
	static void Cal(char[] op) {
		long solNum = nums[0];
		
		boolean flag = true;
		for(int i = 0; i < op.length && flag; i++) {
			switch(op[i]) {
			case '+' :
				solNum += nums[i + 1];
				break;
			case '-' :
				solNum -= nums[i + 1];
				break;
			case '*' :
				solNum *= nums[i + 1];
				break;
			case '/' :
				solNum /= nums[i + 1];
				break;
			}
		}
		
		if(solNum < min)
			min = solNum;
		if(solNum > max)
			max = solNum;
	}
	
	static void perm(char[] opers, int idx) {
		if(opers.length == idx) {
			Cal(opers);
			return;
		}
		
		for(int i = idx; i < opers.length; i++) {
			swap(opers, i, idx);
			perm(opers, idx + 1);
			swap(opers, i, idx);
		}
	}
	
	static void swap(char[] op, int i, int j) {
		char tmp = op[i];
		op[i] = op[j];
		op[j] = tmp;
	}
}