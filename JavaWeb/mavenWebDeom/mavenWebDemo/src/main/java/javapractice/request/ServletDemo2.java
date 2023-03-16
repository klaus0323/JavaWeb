package javapractice.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2", loadOnStartup = 1)
public class ServletDemo2  implements Servlet {

    @Override
    // servlet初始化方法
    //1. 调用时机：默认情况servlet被第一次访问，只会调用1次
    //2. 特殊情况：服务器初始化 通过@WebServlet(loadOnStartp = -1)修改
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init..");

    }
    @Override
    // servlet 请求方法
    //1. 调用时机：每一次servlet被访问时，可以被调用多次
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet little peanut very cute");
    }
    // servlet 服务终止销毁方法
    //1. 调用时机：内存释放或者服务器关闭，servlet对象会被销毁
    //2. 调用次数：只有一次，destroy之后servlet就没有了
    //tomcat必须被正常关闭，如果直接关了网页不会调用destroy
    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    //-------------------------上面三个是servlet生命周期方法------------------------


    @Override
    // 获取servelet配置对象
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }


}

