package com.Kent.test;

import com.Kent.mapper.BrandMapper;
import com.Kent.mapper.UserMapper;
import com.Kent.pojo.Brand;
import com.Kent.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class UserMapperTest {
    @Test
    public void testSelect() throws IOException {
        // 1. 取得 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 取得 sqlSessionFactory 物件
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 取得 Mapper interface 的代理物件
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 4. 執行方法
        String username = "李四";
        String password = "123";


        User user = userMapper.select(username, password);

//        用來示範 collection 參數傳遞過程，但是因為 set 裡面沒有參數，到 sql 語句時，會因為找不到 sql 的字段佔位符所以出錯
//        User user = userMapper.select(new HashSet());

        System.out.println(user);

        // 5. 釋放資源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        // 1. 取得 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 取得 sqlSessionFactory 物件
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 取得 Mapper interface 的代理物件
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 4. 執行方法
        User user = userMapper.selectById(1);
        System.out.println(user);

        // 5. 釋放資源
        sqlSession.close();
    }
}
