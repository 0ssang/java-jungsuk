package jungsuk.ch5;

import java.util.Scanner;

public class Ex5_13 {
    public static void main(String[] args) {
        String[] words = {"television", "computer", "mouse", "phone"};

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < words.length; i++) {
            char[] question = words[i].toCharArray(); //String을 Char[]로 변환하는 메서드
            //구현 --> char배열 question에 담긴 문자의 위치를 임의로 바꾼다.
            //난수를 생성하여 인덱스로 삼고 섞어버리기
            for(int j = 0; j < question.length; j++){
                int random = (int)(Math.random() * question.length);
                char temp = question[j];
                question[j] = question[random];
                question[random] = temp;
            }

            System.out.printf("Q%d. %s의 정답을 입력하세요.> ", i+1, new String(question));
            String answer = sc.nextLine();

            //trim으로 answer의 좌우 공백을 제거한 후, equals로 word[i]와 비교하기
            if(words[i].equals(answer.trim()))
                System.out.printf("맞았습니다.%n%n");
            else
                System.out.printf("틀렸습니다.%n%n");
        }
    }
}
