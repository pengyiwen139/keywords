package com.atguigu.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.atguigu.bean.KEYWORDS_T_MALL_SKU;
import com.atguigu.bean.T_MALL_CLASS_1;
import com.atguigu.factory.MySqlSessionFactory;
import com.atguigu.mapper.KeywordsMapper;
import com.atguigu.util.MyPropertiesUtil;
import com.google.gson.Gson;

public class Test2 {

	public static void main(String[] args) throws Exception {

		// 获得solr的客户端连接
		HttpSolrServer solr = new HttpSolrServer(MyPropertiesUtil.getMyProperty("mySolr.properties", "solr_url"));
		solr.setParser(new XMLResponseParser());
		solr.setConnectionTimeout(3000);

		// 定义查询参数
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("sku_mch:小明");
		solrQuery.setRows(50);
		solrQuery.setHighlight(true);
		// 向solr查询数据
		QueryResponse query = solr.query(solrQuery);

		List<KEYWORDS_T_MALL_SKU> beans = query.getBeans(KEYWORDS_T_MALL_SKU.class);

		System.out.println(beans);

	}

}
