package com.ex;

public class BoyerMoore강사님 {
	public static void main(String[] args) {
		String str = "a pattern matching algorithm";
		String pattern = "rithm";
		int[] skipTable = new int[256];
		// 해당 문자의 칸에 스킵카운트를 적어주자.
		// 해당 문자가 없는 칸은 패턴의 길이를 적어주자.
		
		for(int i = 0; i < 256; i++)
			skipTable[i] = pattern.length();
		
		for(int i = 0; i < pattern.length(); i++)
			skipTable[pattern.charAt(i)] = pattern.length() - 1 - i;
		
		for(int i = 0; i < str.length(); i++) {
			if(skipTable[str.charAt(i)] == 0) {
				String tmp = str.substring(i - pattern.length() + 1, i + 1);
				if( tmp.equals(pattern) )
					System.out.println((i - pattern.length() + 1) + "에서 시작합니다");
			}
		}
	}
}