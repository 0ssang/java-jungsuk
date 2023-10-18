package ch3;

public class ex3_3 {
    public static void main(String[] args){
        int x = 5;
        x = x++ - ++x;
        System.out.println(x); // 정답은 -2
    }
}
