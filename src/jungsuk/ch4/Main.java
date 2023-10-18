package jungsuk.ch4;

public class Main {
    public static void star1(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void star2(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(i == j) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void star3(){
        for(int i = 5; i > 0; i--){
            for(int j = 1; j <= 5; j++){
                if(i == j) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void star4(){
        for(int i = 0; i < 5; i++){
            for(int j= 0; j < 5; j++){
                if(i == j || i + j == 4) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void star5(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(j <= i) System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void star6(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(j <= 4-i) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void star7(){
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 2*i+(4-i); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void star8(){
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 2*i+(4-i); j++){
                if(j <= 5-i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void star9(){
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if ((j <= 6 - i && j >= i) || (j <= i && j >= 6 - i))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void star10(){
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if ((j <= i && j <= 6 - i) || (j >= 6 - i && j >= i))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void under(){
        System.out.println("-----------------------");
    }
    public static void main(String[] args){
        star1(); under();
        star2(); under();
        star3(); under();
        star4(); under();
        star5(); under();
        star6(); under();
        star7(); under();
        star8(); under();
        star9(); under();
        star10();
    }
}
