public class Q1 {
    public static void main(String[] args){
        System.out.println("i \t i-(i-1)/3*3 \t (i-1)/3+1");
        System.out.println("---------------------------------------");

        for(int i=1; i<=9; i++){
            System.out.printf("%d \t\t\t %d \t\t\t %d%n", i, i-(i-1)/3*3, (i-1)/3+1 );
        }
    }
}
