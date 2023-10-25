import org.junit.Test;

import static org.junit.Assert.*;

public class MethodTest2 {
    //Q2. 5x5 2차원 배열을 받아서 빙고의 갯수를 세어서 반환하는 메서드를
    //작성하고 테스트하시오
    //0이면 체크 안된것, 1이면 체크


    // 5 x 5 배열에서 빙고일 경우 요소의 총 합이 5임을 이용한다.
    // 최대로 가능한 빙고 수 : 12 빙고
    int bingoCnt(int[][] board) {           // 한 번만 검사 하면 되는 빙고
        int count = 0;                      // 빙고 갯수 카운트
        int daegak1 = 0;                    // 좌상단->우하단 대각선 요소의 합 초기화
        int daegak2 = 0;                    // 좌하단->우상단 대각선 요소의 합 초기화

        for (int i = 0; i < 5; i++) {       // 매 줄 마다 검사 해야 하는 빙고
            int garo = 0;                   // 가로줄 요소의 합 초기화
            int sero = 0;                   // 세로줄 요소의 합 초기화
            for(int j = 0; j < 5; j++){
                garo += board[i][j];        // 가로 요소의 총 합
                sero += board[j][i];        // 세로 요소의 총 합
            }
            daegak1 += board[i][i];         // 대각선 요소의 총 합
            daegak2 += board[4-i][i];       // 대각선 요소의 총 합
            if(garo == 5) count++;          // 각 요소의 합이 5이면 빙고 갯수 카운팅
            if(sero == 5) count++;
        }
        if(daegak1 == 5) count++;
        if(daegak2 == 5) count++;

        return count;                       // 빙고 개수의 합 반환
    }

    @Test
    public void garoTest() {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 1, 1, 1, 1},
        };
        assertTrue(bingoCnt(board) == 2);
    }
    @Test
    public void seroTest() {
        int[][] board = {
                {1, 0, 0, 1, 1},
                {1, 0, 0, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 1, 1},
                {1, 0, 0, 1, 1},
        };
        assertTrue(bingoCnt(board) == 3);
    }
    @Test
    public void daegakTest1() {
        int[][] board = {
                {1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 0, 1},
        };
        assertTrue(bingoCnt(board) == 1);
    }
    @Test
    public void daegakTest2() {
        int[][] board = {
                {1, 0, 0, 0, 1},
                {1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1},
        };
        assertTrue(bingoCnt(board) == 2);
    }
    @Test
    public void testAll() {
        int[][] board = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
        };
        assertTrue(bingoCnt(board) == 12);
    }
}
