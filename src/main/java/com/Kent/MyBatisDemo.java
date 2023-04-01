package com.Kent;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
        // 1. 加載 mybatis 的核心設定文件，取得 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 取得 SqlSession 物件，用來執行 sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 執行 sql
        List<Object> users = sqlSession.selectList("test.selectAll");

        System.out.println(users);

        // 4. 釋放資源
        sqlSession.close();
    }
}
