package com.Kent.mapper;


import com.Kent.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    /**
     * 查詢所有
     */

    List<Brand> selectAll();

    /**
     *  查看詳情，根據 Id 查詢
     */
    Brand selectById(int id);
}

