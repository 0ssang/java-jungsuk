import org.junit.Test;

import static org.junit.Assert.*;

public class MethodTest2 {
    //Q2. 5x5 2차원 배열을 받아서 빙고의 갯수를 세어서 반환하는 메서드를
    //작성하고 테스트하시오
    //0이면 체크 안된것, 1이면 체크


    int bingoCnt(int[][] board) {
        int count = 0;
        int daegak1 = 0;                    // 좌상단->우하단 대각선 요소
        int daegak2 = 0;                    // 좌하단->우상단 대각선 요소

        for (int i = 0; i < 5; i++) {
            int garo = 0;                   // 가로줄 요소
            int sero = 0;                   // 세로줄 요소
            for(int j = 0; j < 5; j++){
                garo += board[i][j];
                sero += board[j][i];
            }
            daegak1 += board[i][i];
            daegak2 += board[4-i][i];
            if(garo == 5) count++;
            if(sero == 5) count++;
        }
        if(daegak1 == 5) count++;
        if(daegak2 == 5) count++;

        return count;
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
