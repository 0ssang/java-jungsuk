package jungsuk.ch6;

public class Ex6_20 {
    public static void main(String[] args) {
        int[] original = {1,2,3,4,5,6,7,8,9};
        System.out.println(java.util.Arrays.toString(original));

        int[] result = shuffle(original);
        System.out.println(java.util.Arrays.toString(result));
    }

    static int[] shuffle(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int x = (int)(Math.random() * 9);
            int temp = arr[i];
            arr[i] = arr[x];
            arr[x] = temp;
        }
        return arr;
    }
}
