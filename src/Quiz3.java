import java.util.Arrays;

/**
 * Q3. 아래의 배열에서 각각의 결과를 출력하시오.
 *      1. 중복을 제거
 *      2. 정렬
 */
public class Quiz3 {
    public static void main(String[] args){
        int[] arr = {1, 3, 2, 7, 5, 2, 3, 1, 7};
        int[] counter = new int[10];
        // 카운터배열 구현
        for(int i=0; i < arr.length; i++){
            counter[arr[i]]++;
        }

        //1 중복제거하기 --> 카운터 배열의 카운트가 0이 아닌 요소만 출력.
        System.out.print("중복 제거 결과: ");
        for(int i=0; i < counter.length; i++){
            if(counter[i] != 0) System.out.print(i);
        }

        //2. 정렬하여 출력 --> 카운터의 카운트를 감소시키면서 반복 출력.;
        System.out.print("\n정렬 결과: ");
        for(int i=0; i < counter.length; i++){
            for(int j = counter[i]; j > 0; j--){
                System.out.print(i);
            }
        }
    }
}
