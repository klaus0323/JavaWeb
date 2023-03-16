package javapractice.test;

import javapractice.mapper.BrandMapper;
import javapractice.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class myBatisTest {

    @Test

    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        // get sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectALL();
        System.out.println(brands);

        sqlSession.close();



    }

    @Test
    public void testSelectById() throws IOException {

        int id = 2;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        // get sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectByID(id);
        System.out.println(brand);

        sqlSession.close();



    }
    @Test
    public void testSelectByCondition() throws IOException {

        int status = 0;
        String companyName = "p";
        String brandName = "p";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Map map = new HashMap();

        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        // get sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName)
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        sqlSession.close();



    }

    @Test
    public void testSelectByConditionSingle() throws IOException {

        int status = 0;
        String companyName = "p";
        String brandName = "p";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setcompanyName(companyName);
        brand.setbrandName(brandName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        // get sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName)
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        sqlSession.close();



    }

    @Test
    public void testAdd() throws IOException {

        int status = 0;
        String companyName = "tinytinypeanut.Inc";
        String brandName = "tinytinypeanut";
        String description = "very cute little peanut but might lick you";
        int ordered = 1;


        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setcompanyName(companyName);
        brand.setbrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        // get sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // autocommit is set to false on JDBC level
        // must manually commit otherwise will fail.
        brandMapper.add(brand);
        List<Brand> brands = brandMapper.selectALL();
        System.out.println(brands);

        // 提交
        sqlSession.commit();
        sqlSession.close();



    }

    @Test
    public void testUpdate() throws IOException {

        int status = 0;
        String companyName = "goudan.Inc";
        String brandName = "chouchougoudan";
        String description = "dogegg";
        int ordered = 100;
        int id = 6;


        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setcompanyName(companyName);
        brand.setbrandName(null);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setId(id);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        // get sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // autocommit is set to false on JDBC level
        // must manually commit otherwise will fail.
        brandMapper.update(brand);
        List<Brand> brands = brandMapper.selectALL();
        System.out.println(brands);

        // 提交
        sqlSession.commit();
        sqlSession.close();



    }
    @Test
    public void testDelete() throws IOException {


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        // get sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // autocommit is set to false on JDBC level
        // must manually commit otherwise will fail.
        int[] arr = {1,3};
        brandMapper.deleteByIDs(arr);
        List<Brand> brands = brandMapper.selectALL();
        System.out.println(brands);

        // 提交
        sqlSession.commit();
        sqlSession.close();



    }

}
