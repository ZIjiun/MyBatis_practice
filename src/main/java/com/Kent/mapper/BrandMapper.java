package com.Kent.mapper;


import com.Kent.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /**
     * 查詢所有
     */

    List<Brand> selectAll();

    /**
     *  查看詳情，根據 Id 查詢
     */
    Brand selectById(int id);

    /**
     * 條件查詢
     *  * 參數查詢
     *      1. 散裝參數: 如果 method 中有多個參數，需要使用 @Param("SQL參數佔位符名稱")
     *      2. 物件參數: 物件的屬性名稱要和參數佔位符名稱一致
     *      3. map 集合參數
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
//    List<Brand> selectByCondition(@Param("status")int status, @Param("companyName")String companyName, @Param("brandName")String brandName);
//    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);
}

