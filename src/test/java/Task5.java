import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Task5 {

    @DataProvider(name="num")
    public Iterator<Object[]> Numbers() throws IOException{
        return (Iterator<Object[]>)new CSVData("testNG1008.csv");
//        return (Iterator<Object[]>)new CSVData("testNG1008.csv");
    }
    @Test(dataProvider="num")
    public void testAdd(Map<String, String> data){
        float num1=Float.parseFloat(data.get("n1"));
        float num2=Float.parseFloat(data.get("n2"));
        float expectedResult=Float.parseFloat(data.get("r1"));
        Float expect = num1 + num2;
        Assert.assertEquals(expect, expectedResult);
        System.out.println("num1 = " + num1 + " , num2 = " + num2 + " , expect = " + expect);
    }
}