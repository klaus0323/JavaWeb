package web.servlet;

import com.alibaba.fastjson.JSON;
import pojo.Brand;
import pojo.PageBean;
import service.BrandService;
import service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        // 调用方法找到brands
        List<Brand> brands = brandService.selectAll();

        String jsonString = JSON.toJSONString(brands);

        response.getWriter().write(jsonString);

    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受数据getReader
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.add(brand);

        response.getWriter().write("fuck you it's success");
    }

    //批量删除
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受数据getReader
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        // 转成数组
        int[] ids = JSON.parseObject(params, int[].class);
        brandService.deleteByIds(ids);

        response.getWriter().write("fuck you it's success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        // 调用方法找到brands

        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        PageBean<Brand> brands = brandService.selectByPage(currentPage, pageSize);


        String jsonString = JSON.toJSONString(brands);

        response.getWriter().write(jsonString);

    }
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        // 调用方法找到brands

        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 获取对应的查询条件对象
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);

        PageBean<Brand> brands = brandService.selectByPageAndCondition(currentPage, pageSize, brand);


        String jsonString = JSON.toJSONString(brands);

        response.getWriter().write(jsonString);

    }
}
