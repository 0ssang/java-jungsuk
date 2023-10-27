package jungsuk.ch7;

public class Ex7_18 {
    public static void action(Robot r){
        if(r instanceof DanceRobot){
            DanceRobot d = (DanceRobot)r;
            d.dance();
        } else if (r instanceof SingRobot) {
            SingRobot s = (SingRobot)r;
            s.dance();
        } else {
            DrawRobot w = (DrawRobot)r;
            w.dance();
        }
    }
    public static void main(String[] args) {
        Robot[] arr = {new DanceRobot(), new SingRobot(), new DrawRobot()};
        for (int i = 0; i < arr.length; i++) {
            action(arr[i]);
        }
    }
}
class Robot{

}
class DanceRobot extends Robot{
    void dance(){
        System.out.println("츰을 춥니다.");
    }
}
class SingRobot extends Robot{
    void dance(){
        System.out.println("노래를 합니다.");
    }
}
class DrawRobot extends Robot{
    void dance(){
        System.out.println("그림을 그립니다.");
    }
}
