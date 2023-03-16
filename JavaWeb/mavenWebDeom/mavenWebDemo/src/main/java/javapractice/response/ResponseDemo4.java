package javapractice.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp4")

// 设置字符数据响应
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileInputStream fis = new FileInputStream("c://Users/Klaus Yan/Desktop/CS5330/dogegg.jpg");

        ServletOutputStream os = response.getOutputStream();

        IOUtils.copy(fis, os);
        // copy stream, not useful
//        byte[] buff = new byte[1024];
//        int len = 0;
//
//        while ((len = fis.read(buff)) != -1) {
//            os.write(buff, 0, len);
//        }


        fis.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
