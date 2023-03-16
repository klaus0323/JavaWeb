package json;

import com.alibaba.fastjson.JSON;

public class FastJSONDemo {
    public static void main(String[] args) {
        //1. 把一个java对象转成json字符串
        User user = new User();
        user.setId(1);
        user.setUsername("stinky little peanut");
        user.setPassword("fafafa");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

        //2. 把json字符串转为java对象

        User newUser = JSON.parseObject("{\"id\":1,\"password\":\"fafafa\",\"username\":\"stinky little peanut\"}", User.class);

        System.out.println(newUser.toString());
    }
}
