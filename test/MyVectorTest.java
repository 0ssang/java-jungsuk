import jungsuk.ch11.MyVector;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyVectorTest {
    MyVector mv = new MyVector(10);
    Vector<Integer> v = new Vector<>(50);

    @Test
    public void emptyTest(){
        assertTrue(v.isEmpty());
    }

    @Test
    public void addTest(){
        v.add((Integer)1);
        v.add((Integer)2);
        v.add((Integer)3);
        v.add((Integer)4);
        v.add((Integer)5);
        assertEquals(5, v.size());
    }


    @Test
    public void indexOfTest(){
        v.add((Integer)1);
        v.add((Integer)2);
        v.add((Integer)3);
        v.add((Integer)4);
        v.add((Integer)5);
        assertEquals(4, v.indexOf((Integer)5));
    }

    @Test
    public void sizeTest(){
        for (int i = 0; i < 9999999; i++) {
            mv.add(i);
        }
        assertEquals(9999999, mv.size());
    }
}
