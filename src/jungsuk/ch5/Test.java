package jungsuk.ch5;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){

        int[] code = {-4, -1, 3, 6, 11};
        int[] arr  = new int[10];

        for(int i=0; i < arr.length; i++){
            int temp = (int)(Math.random() * code.length);
            arr[i] = code[temp];
        }
        System.out.println(Arrays.toString(arr));
    }
}
