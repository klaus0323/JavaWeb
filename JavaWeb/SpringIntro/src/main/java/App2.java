import dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

public class App2 {
    public static void main(String[] args) {

        // 3. 获取ioc容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 4. 获取bean

        BookService bookService = (BookService) ctx.getBean("bookEbi");
        // spring默认创造的bean是一个单例，可以用scope改变
        // 如果造出来的不是单例，容易占用太多资源

        bookService.save();
    }
}
