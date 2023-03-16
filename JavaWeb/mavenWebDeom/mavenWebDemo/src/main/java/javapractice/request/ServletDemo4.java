package javapractice.request;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

public class ServletDemo4 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;

        String method = request.getMethod();

        if("GET".equals(method)) {
            doGet(req, res);
        }else if ("POST".equals(method)) {
            doPost(req, res);
        }
    }
    protected void doGet(ServletRequest req, ServletResponse res) {

    }

    protected void doPost(ServletRequest req, ServletResponse res) {

    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
