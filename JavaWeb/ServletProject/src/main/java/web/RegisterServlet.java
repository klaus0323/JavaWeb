package web;

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 接受用户数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // mybatis 完成查询
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // sqlsessionfactory to get sqlsession对象

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //mapper

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setPassword(password);
        u.setUsername(username);
        User user = userMapper.selectByUserName(username);



        //判断user为null？
        //设置对应输出流
        PrintWriter writer = response.getWriter();
        if (user != null) {
            writer.write("user already exist");
        } else {
            userMapper.add(u);
            sqlSession.commit();
            writer.write("register successful");
        }

        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
