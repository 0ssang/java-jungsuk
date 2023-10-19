/**
 * Q2. (야구게임)  두 배열을 비교해서 값이 같으면 변수 b의 값을 1 증가
 *               값이 같고 자리(index)도 같으면 변수 s의 값을 1 증가
 *               비교 결과를 출력하시오(예시: 1S2B)
 *               int[] arr1 = {1, 2, 3}
 *               int[] arr2 = {1, 3, 2}
 */
public class Quiz2 {
    public static void main(String[] args){
        int[] arr1 = {3, 2, 1};
        int[] arr2 = {1, 3, 2};
        int s = 0;
        int b = 0;

        //2중 for문으로 arr1과 arr2을 요소 하나하나 다 비교한다.
        for(int i=0; i < arr1.length; i++){
            for(int j=0; j < arr2.length; j++){
                //같은 값을 발견하는가?
                if(arr1[i] == arr2[j]){
                    // 참일때 index도 같은가?
                    if(i == j)
                    // 참이면 s++
                        s++;
                    // 거짓이면 b++
                    else b++;
                }
            }
        }
                System.out.println(s+"S"+b+"B");
    }
}
