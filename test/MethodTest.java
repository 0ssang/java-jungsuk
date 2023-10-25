import org.junit.Test;

import static org.junit.Assert.*;
public class MethodTest {
    //Q1. 세 개의 정수를 받아서 중간 값을 반환하는 메서드 mid를 작성하고 테스트하시오.

    int mid(int x, int y, int z){
        return (x > y) ? (x > z) ? (y > z) ? y : z : x : (y > z) ? (z > x) ? z : x : y;
    }

    @Test
    public void test(){
        assertTrue(mid(3,2,1) == 2);
    }
    @Test
    public void test1(){
        assertTrue(mid(1,2,3) == 2);
    }@Test
    public void test2(){
        assertTrue(mid(4,7,6) == 6);
    }@Test
    public void test3(){
        assertTrue(mid(5,4,3) == 4);
    }
}