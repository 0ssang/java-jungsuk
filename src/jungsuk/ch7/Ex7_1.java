package jungsuk.ch7;

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck() {
        for (int i = 0; i < CARD_NUM; i++) {
            if ((i + 1) % 10 == 1 || (i + 1) % 10 == 3 || (i + 1) % 10 == 8) {
                if(i < CARD_NUM / 2)
                    cards[i] = new SutdaCard((i + 1) % 10, true);
                else
                    cards[i] = new SutdaCard((i + 1) % 10, false);
            } else if ((i + 1) % 10 == 0) {
                cards[i] = new SutdaCard(10, false);
            } else
                cards[i] = new SutdaCard((i + 1) % 10, false);
        }
    }

    void shuffle(){
        for (int i = 0; i < CARD_NUM; i++) {
            int r = (int)(Math.random() * 20);
            SutdaCard temp = cards[i];
            cards[i] = cards[r];
            cards[r] = temp;
        }
    }

    SutdaCard pick(int index){
        return cards[index];
    }

    SutdaCard pick(){
        int index = (int)(Math.random() * 20);
        return cards[index];
    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public String toString() {
        return num + (isKwang ? "k" : "");
    }
}

public class Ex7_1 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for (int i = 0; i < deck.cards.length; i++) {
            System.out.print(deck.cards[i]+",");
        }
        System.out.println();
        System.out.println(deck.pick(0));
    }
}
