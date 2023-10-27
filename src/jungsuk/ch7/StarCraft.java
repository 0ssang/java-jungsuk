package jungsuk.ch7;
abstract class Unit{
    int x, y;
    abstract void move(int x, int y);
    void stop(){};
}
class Marine extends Unit{
    void move(int x, int y){}
    void stimpack(){}
}
public class StarCraft {
    public static void main(String[] args) {

    }
}
