package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 用来替换httpservlet
//根据请求的最后一段路径 完成方法分发
public class BaseServlet extends HttpServlet {

    // 根据路径分发方法


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求路径
        String requestURI = req.getRequestURI(); // /projectDemo/brand/selectAll
        //2. 获取最后一段路径，和对应的method是一样的
        String method = requestURI.substring(requestURI.lastIndexOf('/')+1);

        //获取brandserverlet的所有class对象
        // this： 谁调用我，我代表谁

        Class<? extends BaseServlet> cls = this.getClass();

        try {
            Method method1 = cls.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            method1.invoke(this, req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }



        //获取method对象

        //执行方法
    }
}
