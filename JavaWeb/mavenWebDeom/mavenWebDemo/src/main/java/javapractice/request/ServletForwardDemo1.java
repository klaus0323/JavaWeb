package javapractice.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/req5")
public class ServletForwardDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(("/req5"));

        //存储数据

        request.setAttribute("msg", "little peanut");
        request.getRequestDispatcher("/req6").forward(request,response);
        //转发到另一个资源
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
