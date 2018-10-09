import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class DBconnection implements Iterator<Object[]> {
    ArrayList<String> csvList=new ArrayList<String>();
    int rowNum=0;     //行数
    int columnNum=0;  //列数
    int curRowNo=0;   //当前行数
    String columnName[];  //列名
    //    驱动类名
    String driver="com.mysql.cj.jdbc.Driver";
    //    URL格式,最后为数据库名
    String url="jdbc:mysql://localhost:3306/zou?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF8";    //JavaTest为你的数据库名称
    String user="root";
    String password="123";
    Connection coon=null;
    public DBconnection(String sql){
        try{
//            加载驱动程序
            Class.forName(driver);
            coon=(Connection) DriverManager.getConnection(url,user,password);
            if(!coon.isClosed()){
                System.out.println("成功连接数据库！");
                select(sql);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        if(rowNum==0||curRowNo>=rowNum){
            try {
                this.coon.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return false;
        }else{
            return true;
        }
    }

    /**
     * 获取一组参数，即一行数据
     */
    @Override
    public Object[] next() {
        // TODO Auto-generated method stub
        Map<String,String> s=new TreeMap<String,String>();
//        DbBean dbBean = dbList.get(curRowNo);
        for(int i=0;i<this.columnNum;i++){
//            s.put(columnName[i], csvCell[i]);
        }
        Object[] d=new Object[1];
//        d[0]=s;
        this.curRowNo++;
        return d;
    }

    //    查询
    public void select(String sql){
          //查询  NGtest_data 表中的信息
        try{
            Statement stmt=(Statement)this.coon.createStatement();
            ResultSet rs=(ResultSet)stmt.executeQuery(sql);   //得到的是结果的集合
            System.out.println("--------------------------------");
            System.out.println("_id"+"\t"+"isTest"+"\t"+"a"+"\t"+"b"+"\t"+"expected");
            System.out.println("--------------------------------");
            while(rs.next()){
                DbBean dbBean = new DbBean();
                int id=rs.getInt("_id");
                dbBean.set_id(id);
                String isTest=rs.getString("isTest");
                dbBean.setIsTest(isTest);
                String a=rs.getString("a");
                dbBean.setA(a);
                String b=rs.getString("b");
                dbBean.setB(b);
                String expected=rs.getString("expected");
                dbBean.setExpected(expected);
                System.out.println(id + "\t" + isTest +"\t"+a +"\t"+b +"\t"+expected );
//                dbList.add(dbBean);
                this.rowNum++;
                this.curRowNo++;
            }
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }









    //    增加数据
    public void add(String name,int age,String gender){
//        String sql="insert into usrInfo(username,gender,age) values(?,?,?)";　　//向usrInfo表中插入数据
        String sql="insert into usrInfo(age,gender,username) values('"+age+"','"+gender+"','"+name+"')";
        try{
            PreparedStatement preStmt=(PreparedStatement)this.coon.prepareStatement(sql);
//            preStmt.setString(1, name);
//            preStmt.setInt(3, age);
//            preStmt.setString(2, gender);　　//和上面的注释的一块组成另外一种插入方法
            preStmt.executeUpdate();
            System.out.println("插入数据成功！");
            preStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    
//    更改数据

    public void update(String name,int age){
        String sql="update usrInfo set age=? where username=?";   //推荐使用这种方式，下面的那种注释方式不知道为啥有时候不好使
//        String sql="update usrInfo set age="+age+" where username='"+name+"'";　　
        try{
            PreparedStatement prestmt=(PreparedStatement)this.coon.prepareStatement(sql);
            prestmt.setInt(1, age);
            prestmt.setString(2,name);
            prestmt.executeUpdate();


//            Statement stmt=(Statement)this.coon.createStatement();
//            stmt.executeUpdate(sql);
            System.out.println("更改数据成功！");
            prestmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //    删除数据
    public void del(String name){
        String sql="delete from usrInfo where username=?";
        try{
            PreparedStatement prestmt=(PreparedStatement)this.coon.prepareStatement(sql);
            prestmt.setString(1, name);
            prestmt.executeUpdate();
            System.out.println("删除数据成功！");
            prestmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}