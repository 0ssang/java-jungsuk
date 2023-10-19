package jungsuk.ch4;

public class Ex4_12 {
    public static void main(String[] args){
        for(int i = 1; i <= 9; i++){
            for(int j = 1 ; j <= 3; j++){
                int x = (i-1)/3*3+j+1;
                int y = (i%3 == 0)? 3: i%3;
                if(x == 10) break;
                System.out.printf("%d * %d = %d\t",x, y, x*y);
            }
            System.out.println();
            if(i%3 == 0) System.out.println();
        }
    }
}
