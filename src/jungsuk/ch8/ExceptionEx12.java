package jungsuk.ch8;

public class ExceptionEx12 {
    public static void main(String[] args) throws Exception{
        method1();
    }
    public static void method1() throws Exception{
        method2(); //예외를 발생시켰으나 try-catch 구문으로 예외처리를 해주지 않았으므로 이 메서드는 종료되면서 method1로 예외를 넘겨준다.
    }
    public static  void method2() throws Exception{
        throw new Exception();
    }
}
