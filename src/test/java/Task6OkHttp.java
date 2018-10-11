import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task6OkHttp {
    /**
     * 测试方法
     *
     */
    @Test
    public void testOkHttp() {
        String string = null;
//         try {
//             string = test.get("http://172.21.3.232:8088/operationLog");
//             System.out.println(string);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//
//         try {
//             string = test.post("http://172.21.3.232:8088/operationLog?");
//             System.out.println(string);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

        try {
            Map<String, String> map = new LinkedHashMap<String, String>();
            map.put("phone", "15058346807");
            string = MyOkHttp.post("http://kedouapi.imkedou.com/Login/clearUserData", map);
            //string = test.post("http://172.21.3.232:8088/operatorRole/addOperatorRole","{\"roleName\":\"aa\",\"roleDesc\":\"bb\",\"id\":\"\"}");
            System.out.println(UniCode.decodeUnicode(string));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            string = test.put("http://172.21.3.232:8088/operatorRole/1","{\"id\": 1,\"roleDesc\": \"string\",\"roleName\": \"string\"}");
//            System.out.println(string);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}

