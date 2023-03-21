package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Brand;

import java.util.List;

public interface BrandMapper {

    // 全选
    List<Brand> selectAll();

    // Brand selectByID();
    void add(Brand brand);

    // 批量删除
    void deleteByIds(@Param("ids") int[] ids);


    // 分页查询 limit
    // 参数1：开始索引
    // 参数2：查询的条目数

    // 页面传递的参数：当前页码，每页条数
    // 参数1： （当前页码-1）* 每页条数
    // 查询条目数：每页条数

    List<Brand> selectByPage(@Param("begin") int begin, @Param("pageSize") int pageSize);

    int selectTotalCount();

    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("pageSize") int pageSize, @Param("brand") Brand brand);
    int selectTotalCountByCondition(Brand brand);




}
