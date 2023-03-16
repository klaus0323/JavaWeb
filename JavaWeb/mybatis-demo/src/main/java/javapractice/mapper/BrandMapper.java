package javapractice.mapper;

import javapractice.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /**
     * find all
     *
     */
    List<Brand> selectALL();

    Brand selectByID(int id);

    /**
     * 条件查询
     *  参数接受有几种方式
     *  散装参数：用@Param注解对应sql里面占位符
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
//    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

//    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    /**
     * 单条件动态查询
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);

    void update(Brand brand);
    void deleteByIDs(@Param("ids") int[] ids);
    void deleteByID(int id);

}
