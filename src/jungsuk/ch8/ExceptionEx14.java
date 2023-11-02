package jungsuk.ch8;

public class ExceptionEx14 {
    public static void main(String[] args) {
        try{
            method3();
        } catch (Exception e){
            System.out.println("main메서드에서 예외가 처리되었습니다.");
            e.printStackTrace();
        }
    }

    static void method3() throws Exception{
        throw new Exception();
    }
}
