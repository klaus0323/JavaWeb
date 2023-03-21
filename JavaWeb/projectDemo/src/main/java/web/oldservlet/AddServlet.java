package web.oldservlet;

import com.alibaba.fastjson.JSON;
import pojo.Brand;
import service.BrandService;
import service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

//servlet数量过多，不方便
@WebServlet(value = "/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接受数据getReader
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.add(brand);

        response.getWriter().write("fuck you it's success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
