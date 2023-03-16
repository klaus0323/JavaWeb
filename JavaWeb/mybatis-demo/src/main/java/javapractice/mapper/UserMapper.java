package javapractice.mapper;

import javapractice.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    User selectById(int id);

    /**
     * 多个参数：封装为map集合
     * map.put(arg1, param value）
     * map.put(param1, param value
     * @param username
     * @param password
     * @return
     */
    User select(@Param("username") String username, @Param("password") String password);
}
