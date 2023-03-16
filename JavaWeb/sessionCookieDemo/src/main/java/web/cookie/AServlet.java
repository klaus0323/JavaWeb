package web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(value = "/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //发送cookie

        // 1. 创建cookie对象

        Cookie cookie = new Cookie("username", "goudan");

        // 文字转换

        String value = "我是狗蛋";
        value = URLEncoder.encode(value, "UTF-8");
        System.out.println("我是狗蛋");

        Cookie cn = new Cookie("username", value);

        //在这里可以设置存活时间
        cookie.setMaxAge(60*60);

        // 发送cookie
        response.addCookie(cn);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
