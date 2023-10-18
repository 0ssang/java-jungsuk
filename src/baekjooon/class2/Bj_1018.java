package baekjooon.class2;

import java.util.Scanner;

public class Bj_1018 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] board = new char[N][M];
        for(int i = 0; i < N; i++){
            String line = sc.nextLine();
            board[i] = line.toCharArray();
        }
        // 문제 입력 및 체스 보드 생성


    }
}
