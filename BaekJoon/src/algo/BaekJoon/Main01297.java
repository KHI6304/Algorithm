package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01297 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int diagonal = Integer.parseInt(st.nextToken());	// 대각선 길
		int heightRatio = Integer.parseInt(st.nextToken());
		int widthRatio = Integer.parseInt(st.nextToken());
		
		double num = Math.pow(diagonal, 2) / ( Math.pow(heightRatio, 2) + Math.pow(widthRatio, 2) );
		int height = (int) Math.sqrt( num * Math.pow(heightRatio, 2) );
		int width = (int) Math.sqrt( num * Math.pow(widthRatio, 2) );
		
		System.out.println(height + " " + width);
	}
}