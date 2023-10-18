package class2;

import java.util.*;

public class S5_2751 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list =  new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(sc.nextInt());
        }

        Collections.sort(list);
        for(int v : list){
            sb.append(v).append('\n');
        }
        System.out.println(sb);
    }
}
