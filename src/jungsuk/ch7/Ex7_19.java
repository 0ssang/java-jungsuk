package jungsuk.ch7;

import java.util.Arrays;

public class Ex7_19 {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Tv());
        b.buy(new Audio());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());

        b.summary();
    }
}
class Buyer{
    int money = 1000;
    Product[] cart = new Product[3];
    int i = 0;

    void buy(Product p){
        if(money < p.price){
            System.out.println("잔액이 부족하여 "+p.toString()+"을,를 살 수 없습니다.");
            return;
        }else {
            money -= p.price;
            add(p);
        }
    }
    void add(Product p){
        if(i >= cart.length){
            Product[] newCart = new Product[cart.length * 2];
            System.arraycopy(cart, 0, newCart, 0, cart.length);
            cart = newCart;
        }
        cart[i++] = p;
    }
    void summary(){
        int sum = 0;
        String list = "";
        for (int j = 0; j < cart.length; j++) {
            if(cart[j] != null){
                sum += cart[j].price;
                list += cart[j].toString()+",";
            }
        }
        System.out.println("구입한 물건: "+ list);
        System.out.println("사용한 금액 : "+ sum);
        System.out.println("남은 금액: "+money);
    }
}
class Product{
    int price;

    Product(int price){
        this.price = price;
    }
}

class Tv extends Product{
    Tv(){super(100);}
    public String toString(){return "Tv";}
}
class Computer extends Product{
    Computer(){super(200);}
    public String toString(){return "Computer";}
}
class Audio extends Product{
    Audio(){super(50);}
    public String toString(){return "Audio";}
}
