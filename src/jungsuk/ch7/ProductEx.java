package jungsuk.ch7;
class Product1{
    int price;
    int bonusPoint;

    Product1(int price){
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
    Product1(){}
}

class Tv1 extends Product1{
    Tv1(){
        super(100);
    }
    public String toString(){
        return "Tv1";
    }
}

class Computer1 extends Product1{
    Computer1(){super(100);}
    public String toString(){return "Computer1";}
}

class Audio1 extends Product1{
    Audio1(){super(50);}
    public String toString(){return "Audio1";}
}

class Buyer1{
    int money = 1000;
    int bonusPoint = 0;
    Product1[] item = new Product1[10];
    int i = 0;

    void buy(Product1 p){
        if(money < p.price){
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        item[i++] = p;
        System.out.println(p+"를 구입하셨습니다.");
    }

    void summary(){
        int sum = 0;
        String itemList = "";
        for (int j = 0; j < item.length; j++) {
            if(item[j] == null) break;
            sum += item[j].price;
            itemList += item[j] + ", ";
        }
        System.out.println("구입하신 물품의 총금액은 "+ sum + "만원입니다.");
        System.out.println("구입하신 제품은 "+ itemList + "입니다.");
    }
}

public class ProductEx {
    public static void main(String[] args) {
        Buyer1 b = new Buyer1();

        b.buy(new Tv1());
        b.buy(new Computer1());
        b.buy(new Audio1());
        b.summary();
    }
}
