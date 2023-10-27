package jungsuk.ch7;

public class CastingTest1 {
    public static void main(String[] args) {
        Car car = null;
        fireEngine fe = new fireEngine();
        fireEngine fe2 = null;

        fe.water();
        car = fe;
        fe2 = (fireEngine) car;
        fe2.water();
    }
}

class Car{
    String color;
    int door;
    void drive(){
        System.out.println("drive, Brrrrrr~");
    }
    void stop(){
        System.out.println("stop!!!!");
    }
}
class fireEngine extends Car{
    void water(){
        System.out.println("water!!!!");
    }
}
