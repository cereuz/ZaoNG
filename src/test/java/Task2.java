import org.testng.Assert;
import org.testng.annotations.*;

public class Task2 {
    @Test
    public void doTest1(){
        int a = 1;
        int b = 5;
        int res = a + b;
        System.out.println("result = " + res);
        Assert.assertEquals(res,6);
    }

    @Test
    public void doTest2(){
        int a = 2;
        int b = 2;
        int res = a + b;
        System.out.println("result = " + res);
        Assert.assertEquals(res,4);
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest 操作");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest 操作");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass 操作");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass 操作");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod 操作");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod 操作");
    }
}
