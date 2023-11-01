package jungsuk.ch7;

public class Ex7_20 {
    public static void main(String[] args) {
        Parent1 p = new Child1();
        Child1 c = new Child1();

        System.out.println(p.x);
        p.method();
        System.out.println(c.x);
        c.mehtod();
    }
}
class Parent1{
    int x = 100;
    void method(){
        System.out.println("Parent Method");
    }
}

class Child1 extends Parent1{
    int x = 200;
    void mehtod(){
        System.out.println("Child Method");
    }
}
