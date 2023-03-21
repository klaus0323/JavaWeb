package service;

import pojo.Brand;
import pojo.PageBean;

import java.util.List;

public interface BrandService {

    // 全选
    List<Brand> selectAll();

    // 添加注释
    void add(Brand brand);

    void deleteByIds(int[] ids);

    /**
     *
     * @param currentPage 当前页码
     * @param pageSize 每页条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);


}
