import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class Task4 {
    @Test(dataProvider = "testData")
    public void doTest(Map<String,String> data){
        System.out.println(data.get("测试名称"));
        int a = Integer.valueOf(data.get("a"));
        int b = Integer.valueOf(data.get("b"));
        int expected = Integer.valueOf(data.get("期望值"));
        Assert.assertEquals(a + b, expected);
    }

    @DataProvider(name = "testData")
    public Iterator<Object[]> testData() throws IOException {
//        return new ExcelUtils("E:\\testwork\\testNG1008.xls","testNG1008");
        return null;
    }

}
