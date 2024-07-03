/*
 * Author : 문범수
 * Date : 2024-03-15
 * subject : 
 * page : https://www.acmicpc.net/problem/1074
 * main : 분할정복 & 재귀함수
 * issue : 
 * name : no_1074.java
 * duration : m
 * no : 1074
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no_1074 {
	static int N, R, C, index, size;
	static int[][] matrix;
	static Queue<int[]> start; // 시작위치 지정 queue

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		N = Integer.parseInt(token.nextToken());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		index = 0;
		start = new LinkedList<>();

		size = (int) Math.pow(N, 2); // 나오는 z 패턴의 갯수
		matrix = new int[size][size];

	}
}