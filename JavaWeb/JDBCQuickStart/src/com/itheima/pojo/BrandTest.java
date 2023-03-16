package com.itheima.pojo;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {

    /**
     * 1. sql
     * 2. para?
     * 3. result
     */
    @Test
    public void testSelectAll() throws Exception {

        // load connection
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        // sql
        String sql = "select * from tb_brand";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();
        List<Brand> brands = new ArrayList<>();
        while (rs.next()) {
            //get data
            Integer id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            Integer ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            Integer status = rs.getInt("status");

            Brand brand = new Brand();
            brand.setId(id);
            brand.setCompanyName(companyName);
            brand.setDescription(description);
            brand.setOrder(ordered);
            brand.setStatus(status);
            brand.setBrandName(brandName);

            brands.add(brand);

            // seal data
        }

        System.out.println(brands);
        pstmt.close();
        conn.close();
        rs.close();

    }

    @Test
    public void testAdd() throws Exception {

        String brandName = "little lamb";
        String companyName = "littlelamb.Inc";
        int ordered = 1;
        String description = "horny little lamb from calihornia";
        int status = 0;
        int id = 20;

        // load connection
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        // sql
        String sql = "update tb_brand set brand_name = ?, company_name = ?, ordered = ?, description = ?, status = ? where id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6, id);

        // perform sql
        int count = pstmt.executeUpdate();
        Boolean vari = count > 0?true:false;

        System.out.println(vari);
        pstmt.close();
        conn.close();


    }
}
