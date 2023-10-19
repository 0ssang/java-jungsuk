package jungsuk.ch4;

import java.util.Scanner;

public class NumQuiz {
    public static void main(String[] args){
        int answer = (int)(Math.random()*100)+1;
        int input = 0;
        int count = 0;

        Scanner sc = new Scanner(System.in);
        do{
            count++;
            System.out.print("1과 100 사이의 값을 입력하세요 : ");
            input =  sc.nextInt();

            if(input == answer){
                System.out.println("정답 :"+input+"\t 시도 횟수 : "+count);
                break;
            }
            System.out.println("오답입니다.");
        }while (true);
    }

}
