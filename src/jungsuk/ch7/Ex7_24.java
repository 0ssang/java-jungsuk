package jungsuk.ch7;

public class Ex7_24 {
    public static void main(String[] args) {
        Fighter f = new Fighter();
        if(f instanceof Unit)
            System.out.println("f는 Unit 클래스의 자손입니다.");
        if(f instanceof Fightable)
            System.out.println("f는 Fighterble 인터페이스를 구현했습니다.");
    }
}
interface Fightable extends Movable,Attackable{}
interface Movable {void move(int x, int y);}
interface Attackable{void attack(Unit u);}

class Unit{
    int currentHP;
    int x;
    int y;
}

class Fighter extends Unit implements Fightable{
    public void move(int x, int y){}
    public void attack(Unit u){}
}
