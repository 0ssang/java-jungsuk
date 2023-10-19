package jungsuk.ch5;

public class Ex5_7 {
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("USAGE java Ex5_7 3120");
            System.exit(0);
        }

        //문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
        int money = Integer.parseInt(args[0]);

        System.out.println("money="+money);

        int[] coinUnit = {500, 100, 50, 10};
        int[] coin = {5, 5, 5, 5};

        for(int i=0; i < coinUnit.length; i++){

        }
    }
}
