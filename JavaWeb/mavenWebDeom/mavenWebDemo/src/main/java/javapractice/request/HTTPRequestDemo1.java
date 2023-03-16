package javapractice.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/req1")
public class HTTPRequestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getMethod()
        String method = req.getMethod();
        System.out.println(method); //GET

        //getContextPath()
        String contextPath = req.getContextPath();
        System.out.println(contextPath); //项目名称mavenWebDemo
        //String Buffer getrequestURL()

        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());
        //getRequestURI()

        String uri = req.getRequestURI();
        System.out.println(uri);
        //getQueryString()

        String queryString = req.getQueryString();
        System.out.println(queryString);

        //获取请求头，代表浏览器版本信息
        String header = req.getHeader("user-agent");
        System.out.println(header);
    }

    @Override
    // get 用string post用输入流
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //.请求体 请求参数
        //1.字符输入流
        BufferedReader br = req.getReader();

        String line = br.readLine();
        System.out.println(line);
    }
}
