package com.Kent.test;

import com.Kent.mapper.BrandMapper;
import com.Kent.pojo.Brand;
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

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        // 1. 取得 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 取得 sqlSessionFactory 物件
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 取得 Mapper interface 的代理物件
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 執行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        // 5. 釋放資源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        // 接收參數
        int id = 2;

        // 1. 取得 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 取得 sqlSessionFactory 物件
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 取得 Mapper interface 的代理物件
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 執行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        // 5. 釋放資源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        // 接收參數
//        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 處理參數
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 封裝成物件
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setcompanyName(companyName);
//        brand.setbrandName(brandName);

        // 參數封裝成 Map
        Map map = new HashMap();
//        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        // 1. 取得 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 取得 sqlSessionFactory 物件
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 取得 Mapper interface 的代理物件
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 執行方法
//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        // 5. 釋放資源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        // 接收參數
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 處理參數
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 封裝成物件
        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setcompanyName(companyName);
//        brand.setbrandName(brandName);

        // 1. 取得 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 取得 sqlSessionFactory 物件
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 取得 Mapper interface 的代理物件
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 執行方法
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        // 5. 釋放資源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        // 接收參數
        int status = 1;
        String companyName = "波導手機";
        String brandName = "波導";
        String description = "手機中的戰鬥機";
        int ordered = 1;

        // 封裝成物件
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setcompanyName(companyName);
        brand.setbrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        // 1. 取得 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 取得 sqlSessionFactory 物件
//        SqlSession sqlSession = sqlSessionFactory.openSession();

        // true: 自動提交交易，false: 手動提交交易
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        // 3. 取得 Mapper interface 的代理物件
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 執行方法
        brandMapper.add(brand);

        // 取得增加的資料的 id
        Integer id = brand.getId();
        System.out.println(id);

        // 提交 transaction
//        sqlSession.commit();

        // 5. 釋放資源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        // 接收參數
        int status = 1;
        String companyName = "波導手機";
        String brandName = "波導";
        String description = "波導手機,手機中的戰鬥機";
        int ordered = 2050;
        int id = 5;

        // 封裝成物件
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setcompanyName(companyName);
//        brand.setbrandName(brandName);
//        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        // 1. 取得 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 取得 sqlSessionFactory 物件
//        SqlSession sqlSession = sqlSessionFactory.openSession();

        // true: 自動提交交易，false: 手動提交交易
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 取得 Mapper interface 的代理物件
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 執行方法
        // 因為 jdbc 底層執行了 executeUpdate，所以會有一個影響行數的返回值
        int count = brandMapper.update(brand);
        System.out.println(count);

        // 提交 transaction
        sqlSession.commit();

        // 5. 釋放資源
        sqlSession.close();
    }
}
