package com.Kent.mapper;

import com.Kent.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface UserMapper {

    // 返回類型是 List<User>
    List<User> selectAll();

    User selectById(int id);

    /**
     * MyBatis 參數封裝
        * 單個參數:
            1. POJO 類型: 直接使用. 屬性名 (使用 class 裡面的 get 方法取得) 和 sql 語句參數佔位符名稱　一致
            2. Map 集合:　直接使用. 鍵名 和 sql 語句參數佔位符名稱　一致
            3. Collection: 封裝為 Map 集合. 可以使用 @Param 註解，用來替換 Map 集合中預設的 arg 鍵名
                map.put("collection", collection 集合);
                map.put("arg0", collection 集合);
            4. List: 封裝為 Map 集合. 可以使用 @Param 註解，用來替換 Map 集合中預設的 arg 鍵名
                 map.put("collection", list 集合);
                 map.put("list", list 集合);
                 map.put("arg0", list 集合);
            5. Array: 封裝為 Map 集合. 可以使用 @Param 註解，用來替換 Map 集合中預設的 arg 鍵名
                 map.put("array", array);
                 map.put("arg0", array);
            6. 其他類型: example => int，直接使用
        * 多個參數: 封裝為 Map 集合，可以使用 @Param 註解，用來替換 Map 集合中預設的 arg 鍵名
            map.put("arg0", 參數值1)
            map.put("param1", 參數值1)
            map.put("arg1", 參數值2)
            map.put("param2", 參數值2)
            ------------------------------@Param("username")
             map.put("username", 參數值1)
             map.put("param1", 參數值1)
             map.put("arg1", 參數值2)
             map.put("param2", 參數值2)
     */

    User select(@Param("username") String username, @Param("password") String password);

    // 用來示範 collection 參數的傳遞過程
    //    User select(Collection collection);
}

