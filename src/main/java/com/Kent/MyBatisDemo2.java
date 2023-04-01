package com.Kent;

import com.Kent.mapper.UserMapper;
import com.Kent.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Mybatis 代理開發
 */
public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {
        // 1. 加載 mybatis 的核心設定文件，取得 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 取得 SqlSession 物件，用來執行 sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 執行 sql
//        List<Object> users = sqlSession.selectList("test.selectAll");
        // 3.1 取得UserMapper interface 的代理物件，Mybatis 內部會自動完成 interface
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = usermapper.selectAll();
        System.out.println(users);

        // 4. 釋放資源
        sqlSession.close();
    }
}
