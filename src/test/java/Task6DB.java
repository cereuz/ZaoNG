import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

public class Task6DB {
    String  sql="select * from NGtest_data";
    DBconnection dbCon = new DBconnection(sql);

    @Test
    public void test(){
       dbCon.select(sql);
    }

    @Test(dataProvider = "testData")
    public void doTest(Map<String,String> data){
        System.out.println(data.get("_id"));
        int a = Integer.valueOf(data.get("a"));
        int b = Integer.valueOf(data.get("b"));
        int expected = Integer.valueOf(data.get("expected"));
        Assert.assertEquals(a + b,expected);
    }

    /**
     * 根据sql删选出需要执行测试的测试用例
     */
    @DataProvider(name = "testData")
    public Iterator<Object[]> getData()  throws SQLException,ClassNotFoundException{
        return null;
    }
}
