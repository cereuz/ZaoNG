import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task3 {
    @Test(dataProvider = "testData")
    public void doTest(String testName,int a,int b, int expected){
        System.out.println(testName);
        Assert.assertEquals(a + b, expected);
    }

    @DataProvider
    public Object[][] testData(){
        return new Object[][]{
                {"test1",1,2,3},
                {"test2",2,3,4},
                {"test3",3,6,9}
        };
    }

}
