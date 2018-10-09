import java.util.HashMap;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class Task7DB extends Thread {

    private static  MysqlConn t_conn;
    private static String Loading_IT_sql;

    @DataProvider(name = "Data")
    public Object[][] Authentication() throws Exception {
        // 获取数据库数据源用例数据，并返回Object[][]
        Object[][] results = Read_sql_data.Get_DB_TestCase_data(t_conn,Loading_IT_sql);
        for(int i = 0; i < results.length; i++){
            for(int j = 0; j < results[i].length; j++){
               System.out.println(results[i][j].toString());
            }
        }
        return results;
    }

    @Test(dataProvider = "Data")
    public void run_testcase(HashMap<DbBean, DbBean> data) throws Exception {
        System.out.print("当前执行的用例是：第" + (data.get("_id")) + "行:" + "isTest：【"
                + data.get("isTest") + "】--" + "A :【"
                + data.get("a") + "】--" + "B :【"
                + data.get("b") + "】--" + "expected :【"
                + data.get("expected") + "】"
                + "\n");

    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @AfterMethod
    public void afterMethod() {
    }

    @BeforeClass
    public void beforeClass() {

    }

    @AfterClass
    public void afterClass() {
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        System.out.println("Start running");
        Loading_IT_sql = "SELECT * from NGtest_data;";
        String T_mysql_driver = "com.mysql.cj.jdbc.Driver";
        String T_mysql_url="jdbc:mysql://localhost:3306/zou?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF8";    //JavaTest为你的数据库名称
//        String T_mysql_url = "jdbc:mysql://localhost:3306/zou?useUnicode=true&characterEncoding=UTF-8";
        String T_mysql_DB_user = "root";
        String T_mysql_DB_password = "123";
        t_conn = MysqlConn.instance(T_mysql_driver, T_mysql_url, T_mysql_DB_user, T_mysql_DB_password);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("End running \n");
        t_conn.closeDB();
    }

    @BeforeSuite
    public void beforeSuite() {
    }
}

