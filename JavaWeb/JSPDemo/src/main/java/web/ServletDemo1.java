package web;

import pojo.Brand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servletDemo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1, "三只耗子", "三只耗子", 100, "三只耗子，吃完嗷嗷拉肚子", 1));
        brands.add(new Brand(2, "优衣库", "优衣库", 200, "优衣库，服适人生", 0));
        brands.add(new Brand(3, "小米", "小米科技有限公司", 1000, "为发烧而生", 1));

        request.setAttribute("brands", brands);
        request.setAttribute("status", 1);

        request.getRequestDispatcher("/jstl-if.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
