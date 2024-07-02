/*
 * Author : 문범수
 * Date : 2024-07-02
 * subject :
 * page : https://www.acmicpc.net/problem/16236
 * main : Greedy Algorithm
 * issue : Intellij Issue
 * name : babyShark.java
 * duration : m
 * no : 16236
 */

package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class babyShark {
    static int[][] section; // 현재 위치 입력 란
    static int sectionSize, sharkSize, ans; // sectionSize : 공간 크기 / sharkSize : 아기 상어 크기
    static int[] col = {-1, 0, 1, 0}; // 열 방향 탐색
    static int[] row = {0, 1, 0, -1}; // 행 방향 탐색
    static StringTokenizer token;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        sectionSize = Integer.parseInt(reader.readLine());

        section = new int[sectionSize][sectionSize];
        sharkSize = 2; // 초기 상어 크기 2
        ans = 0;

        for(int i = 0; i < 3; i++){
            token = new StringTokenizer(reader.readLine());
            for(int j = 0; j < 3; j++){
                section[i][j] = Integer.parseInt(token.nextToken());
            }
        }

    }
}