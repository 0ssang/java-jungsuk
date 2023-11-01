package jungsuk.ch8;

public class ExceptionEx11 {
    public static void main(String[] args) {
        throw new RuntimeException(); // 예외처리를 하지 않아도 실행이 된다!
        // RuntimeException 과 그 자손클래스들에 해당하는 예외는 프로그래머에 의해 실수로 발생하는 것들이기 때문에 예외처리를 강제하지 않는다.
    }
}
