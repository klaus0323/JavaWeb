package service.impl;


import mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Brand;
import pojo.PageBean;
import service.BrandService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    //创建sqlSessionFactory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();
        sqlSession.close();

        return brands;

    }
    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }
    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {

        //
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // selection process
        List<Brand> rows = mapper.selectByPage((currentPage - 1) * pageSize, pageSize);
        int totalCount = mapper.selectTotalCount();

        //封装pagebean
        PageBean<Brand> pageBean = new PageBean<Brand>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();
        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }

        System.out.println(brand.toString());

        List<Brand> rows = mapper.selectByPageAndCondition((currentPage - 1) * pageSize, pageSize, brand);
        int totalCount = mapper.selectTotalCountByCondition(brand);

        PageBean<Brand> pageBean = new PageBean<Brand>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();
        return pageBean;
    }
}