package pl.szybiak;


import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void should_Add_Two_Numbers(){
        //given
        Calculator calculator = new Calculator();
        //when

        Assert.assertEquals(calculator.add(3,4),7);
        Assert.assertEquals(calculator.add(5,5),10);
        Assert.assertEquals(calculator.add(-3,3),0);
        Assert.assertEquals(calculator.add(2,2),4);
    }
    @Test
    public void should_add_no_two_numbers(){
        Calculator calculator = new Calculator();
        Assert.assertNotEquals(calculator.add(3,3),7);
        Assert.assertNotEquals(calculator.add(-3,3),7);
        Assert.assertNotEquals(calculator.add(1,1),0);
        Assert.assertNotEquals(calculator.add(10,16),20);
    }

    @Test
    public void should_divide_two_numbers(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(100,10),10,0);
    }


    @Test(expected = ArithmeticException.class)
      public void should_no_divide_by_zero(){
        Calculator calculator = new Calculator();
        Assert.assertNotEquals(calculator.divide(10,0),10);
    }

}
