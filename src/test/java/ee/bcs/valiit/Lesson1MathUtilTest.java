package ee.bcs.valiit;

import ee.bcs.valiit.tasks.Balance;
import ee.bcs.valiit.tasks.BankExeption;
import ee.bcs.valiit.tasks.BankService;
import ee.bcs.valiit.tasks.harjutused.Lesson1MathUtil;
import ee.bcs.valiit.tasks.harjutused.Lesson2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class Lesson1MathUtilTest {
    @Test
    public void testmin() {
        Assertions.assertEquals(3,  Lesson1MathUtil.min(3, 4));
        Assertions.assertEquals(3,  Lesson1MathUtil.min(4, 3));
        Assertions.assertEquals(-4,  Lesson1MathUtil.min(3, -4));
    }
@Test
    public void testMax() {
        Assertions.assertEquals(6, Lesson1MathUtil.max(5, 6));
        Assertions.assertEquals(6, Lesson1MathUtil.max(-5, 6));
        Assertions.assertEquals(-5, Lesson1MathUtil.max(-5, -6));
        Assertions.assertEquals(6, Lesson1MathUtil.max(6, 5));
        Assertions.assertEquals(6, Lesson1MathUtil.max(6, -5));
        Assertions.assertEquals(6, Lesson1MathUtil.max(6, 6));




    }


    @Test
    public void testmin3() {

        Assertions.assertEquals(5, Lesson1MathUtil.min3(5, 6, 7));
        Assertions.assertEquals(-5, Lesson1MathUtil.min3(-5, 6000, 7000));
        Assertions.assertEquals(-7, Lesson1MathUtil.min3(-5, -6, -7));
        Assertions.assertEquals(0, Lesson1MathUtil.min3(0, 0, 1));
        Assertions.assertEquals(-1, Lesson1MathUtil.min3(-1, 0, 1));
        Assertions.assertEquals(0, Lesson1MathUtil.min3(0, 0, 0));


    }

    @Test
    public void test3() {

        Assertions.assertEquals(5, Lesson1MathUtil.abs(-5));
        Assertions.assertEquals(5, Lesson1MathUtil.abs(5));


    }
    @Test
    public void testIsEven(){

        Assertions.assertTrue(Lesson1MathUtil.isEven(6));
        Assertions.assertTrue(Lesson1MathUtil.isEven(4));
        Assertions.assertFalse(Lesson1MathUtil.isEven(5));
    }

  @Test
    public void testMax3(){
        Assertions.assertEquals(7,Lesson1MathUtil.max3(5,6,7));

  }




}


