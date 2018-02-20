package com.atguigu.mapper;

import java.util.List;

import com.atguigu.bean.KEYWORDS_T_MALL_SKU;

public interface KeywordsMapper {

	public List<KEYWORDS_T_MALL_SKU> select_sku_list_by_class2(int class_2_id);

}
