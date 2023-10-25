package jungsuk.ch6;

public class Ex6_2 {
    public static void main(String[] args) {
        SutdaCard card1 = new SutdaCard(3, false);
        SutdaCard card2 = new SutdaCard();

        System.out.println(card1.info());
        System.out.println(card2.info());
    }
}
class SutdaCard{
    private int num;
    private boolean isKwang;

    public SutdaCard(){
        this.num = (int)(Math.random() * 10) + 1;
        isKwang = true;
    };

    public SutdaCard(int num, boolean isKwang){
        this.num = num;
        this.isKwang = isKwang;
    }

    public String info(){
        if(this.isKwang) return this.num+"K";
        else return Integer.toString(this.num);
    }
}
