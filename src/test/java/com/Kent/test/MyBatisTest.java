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
import java.util.List;

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
}
