package service.impl;

import dao.BookDao;
import service.BookService;

public class BookServiceImpl implements BookService {

    //5.删除业务层中使用new的方式创建的dao对象，因为耦合度非常高
    private BookDao bookDao;

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
    //6.写一个set方法来传入数据 （开入口）
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
