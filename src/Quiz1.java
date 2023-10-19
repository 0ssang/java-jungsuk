/**
 * Q1. 두 배열을 비교해서 같으면 "같습니다"
 * 다르면 "다릅니다" 라고 출력하세요
 * int[] arr = {1,2,3}
 * int[] arr2 = {1,2,3}

 */
public class Quiz1 {
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 4};
        boolean check = true;

        for(int i=0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                check = false;
                System.out.println("같지 않습니다.");
                break;
            }
        }

        if(check) System.out.println("같습니다.");
    }
}
