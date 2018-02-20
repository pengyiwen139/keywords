package com.atguigu.controller;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.KEYWORDS_T_MALL_SKU;
import com.atguigu.bean.MODEL_T_MALL_ATTR;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.util.MyPropertiesUtil;

@Controller
public class SearchController {

	@RequestMapping("search/{keywords}")
	@ResponseBody
	public List<KEYWORDS_T_MALL_SKU> search(@PathVariable String keywords) {
		// 获得solr的客户端连接
		HttpSolrServer solr = new HttpSolrServer(MyPropertiesUtil.getMyProperty("mySolr.properties", "solr_url"));
		solr.setParser(new XMLResponseParser());
		solr.setConnectionTimeout(3000);

		// 定义查询参数
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("copy_item:" + keywords);
		solrQuery.setRows(50);
		solrQuery.setHighlight(true);
		// 向solr查询数据
		QueryResponse query = null;
		try {
			query = solr.query(solrQuery);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<KEYWORDS_T_MALL_SKU> beans = query.getBeans(KEYWORDS_T_MALL_SKU.class);

		return beans;

	}

}
