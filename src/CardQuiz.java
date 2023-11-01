public class CardQuiz {
    // 메인 메서드
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        deck.shuffle();
        for (int i = 0; i < 5; i++) {
            System.out.print(deck.cards[i]+" / ");
        }
        System.out.println();

        String rank = rankCheck(deck.cards);
        System.out.println(rank);
    }

    // 판정하는 메서드
    public static String rankCheck(Card[] cards){
        int[] arr = new int[5];
        int[] count = new int[15];
        int sum = 0;
        String rank = "";
        // 배열 arr에 카드 숫자로 변환하여 생성
        for (int i = 0; i < 5; i++) {
            if(cards[i].num.equals("A")) {
                arr[i] = 14;
                count[14]++;
            }
            else if(cards[i].num.equals("J")) {
                arr[i] = 11;
                count[11]++;
            }
            else if(cards[i].num.equals("Q")) {
                arr[i] = 12;
                count[12]++;
            }
            else if(cards[i].num.equals("K")) {
                arr[i] = 13;
                count[13]++;
            }
            else {
                arr[i] = Integer.parseInt(cards[i].num);
                count[Integer.parseInt(cards[i].num)]++;
            }
        }

        // 스트레이트 판정 --> 마지막 - 처음 = 무조건 4가 나와야 가능성 있음
        Boolean isFlush = true;
        Boolean isStraight = false;
        if(arr[4] - arr[0] == 4) isStraight = true;

        //플러쉬 & 스트레이트 검사 --> 하나라도 kind가 다르면 플러쉬 아님 , 이전 숫자보다 작은 숫자가 나오면 스트레이트 아님
        for (int i = 0; i < 4; i++) {
            if(!cards[i].kind.equals(cards[i+1].kind))
                isFlush = false;
            if(arr[i] >= arr[i+1])
                isStraight = false;
        }
        if(isFlush && isStraight) return "STRAIGHT FLUSH";
        else if (isFlush && !isStraight) return "FLUSH";
        else if (!isFlush && isStraight) return "STRAIGHT";


        for (int i = 0; i < count.length; i++) {
            if(count[i] >= 2){
                if(count[i] == 4) {
                    return "FOUR_CARD";
                }
                sum += count[i];
            }
        }
        if(sum == 2) rank = "ONE PAIR";
        else if(sum == 3) rank = "THREE CARD";
        else if(sum == 4) rank = "TWO PAIR";
        else if(sum == 5) rank = "FULL HOUSE";
        else rank = "NO PAIR";

        return rank;
    }
}

// 카드
class Card{
    String kind;    // 그림
    String num;        // 숫자

    //생성자
    Card(String kind, String num){
        this.kind = kind;
        this.num = num;
    }

    public String toString(){
        return kind +","+ num;
    }
}
// 카드 덱(생성자로 52장 생성)
class CardDeck{
    final int CARD_NUM = 52;
    final int SPD_NUM = 13;
    final int DIA_NUM = 26;
    final int HRT_NUM = 39;
    Card[] cards = new Card[CARD_NUM];

    CardDeck(){
        for (int i = 0; i < CARD_NUM; i++) {
            if(i < SPD_NUM) {
                if(i == 0) cards[i] = new Card("SPADE","A");
                else if (i == SPD_NUM - 1) cards[i] = new Card("SPADE", "K");
                else if (i == SPD_NUM - 2) cards[i] = new Card("SPADE", "Q");
                else if (i == SPD_NUM - 3) cards[i] = new Card("SPADE", "J");
                else cards[i] = new Card("SPADE", Integer.toString(i+1));
            } else if (i < DIA_NUM) {
                if(i - SPD_NUM == 0) cards[i] = new Card("DIA", "A");
                else if (i == DIA_NUM - 1) cards[i] = new Card("DIA", "K");
                else if (i == DIA_NUM - 2) cards[i] = new Card("DIA", "Q");
                else if (i == DIA_NUM - 3) cards[i] = new Card("DIA", "J");
                else cards[i] = new Card("DIA", Integer.toString(i+1-SPD_NUM));
            } else if (i < HRT_NUM) {
                if(i - DIA_NUM == 0) cards[i] = new Card("HEART", "A");
                else if (i == HRT_NUM - 1) cards[i] = new Card("HEART", "K");
                else if (i == HRT_NUM - 2) cards[i] = new Card("HEART", "Q");
                else if (i == HRT_NUM - 3) cards[i] = new Card("HEART", "J");
                else cards[i] = new Card("HEART", Integer.toString(i+1-DIA_NUM));
            } else {
                if(i - HRT_NUM == 0) cards[i] = new Card("CLOVER", "A");
                else if (i == CARD_NUM - 1) cards[i] = new Card("CLOVER", "K");
                else if (i == CARD_NUM - 2) cards[i] = new Card("CLOVER", "Q");
                else if (i == CARD_NUM - 3) cards[i] = new Card("CLOVER", "J");
                else cards[i] = new Card("CLOVER", Integer.toString(i+1-HRT_NUM));
            }
        }
    }

    // 카드 덱 랜덤하게 섞기...
    void shuffle(){
        for (int i = 0; i < 5; i++) {
            int r = (int)(Math.random() * CARD_NUM);
            Card temp = cards[i];
            cards[i] = cards[r];
            cards[r] = temp;
        }
    }
}