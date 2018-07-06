import org.junit.Assert;
import org.junit.Test;

public class convertTralfamadorianToDecimalTest {

    private Main main = new Main();

    @Test
    public void test1withVerticalBar(){
        int result = main.convertTralfamadorianToDecimal("α|");
        Assert.assertEquals("α|",1,result);
    }

    @Test
    public void test2withVerticalBar(){
        int result = main.convertTralfamadorianToDecimal("γ++δ+β|");
        Assert.assertEquals("γ++δ+β|",342,result);
    }
    @Test
    public void test3withVerticalBar(){
        int result = main.convertTralfamadorianToDecimal("β+xα+θ|");
        Assert.assertEquals("β+xα+θ|",2018,result);
    }
    @Test
    public void test4withoutVerticalBar(){
        int result = main.convertTralfamadorianToDecimal("ι+x");
        Assert.assertEquals("ι+x",9000,result);
    }
    @Test
    public void test5withoutVerticalBar(){
        int result = main.convertTralfamadorianToDecimal("α+xxα++");
        Assert.assertEquals("α+xxα++",100100,result);
    }

}
