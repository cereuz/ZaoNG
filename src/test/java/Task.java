import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task {
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest 操作");
    }

    @Test
    public void doTest(){
        int a = 1;
        int b = 2;
        int res = a + b;
        System.out.println("result = " + res);
        Assert.assertEquals(res,3);
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest 操作");
    }
}
