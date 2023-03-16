package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

public interface UserMapper {


    User selectUser(@Param("username") String username, @Param("password") String password);

    User selectByUserName(@Param("username") String username);

    void add(User user);
}
