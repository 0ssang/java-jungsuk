package jungsuk.ch8;

public class ExceptionEx6 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);
        } catch(Exception e) {      //Exception은 모든 예외의 조상클래스 이므로 모든 예외를 catch 구문에서 처리할 수 있다.
            System.out.println(5);
        }
        System.out.println(6);
    }
}
