package com.test.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/2/16
 */
public class TestSearch {
    @Test
    public void testSimpleSearch() throws SolrServerException {
        //1. 创建和solr服务器的连接
        //http://192.168.200.128:8080/solr连接solr默认实例也就是collection1实例
        //http://192.168.200.128:8080/solr/实例名称例如collection3
        SolrServer solrServer = new HttpSolrServer("http://192.168.200.128:8080/solr");
        //2. 创建查询对象, 这里我们是查询所有
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        //3. 查询并返回响应
        QueryResponse query = solrServer.query(solrQuery);
        //4. 从响应中获取查询结果列表
        SolrDocumentList results = query.getResults();
        //5. 遍历展示结果
        if (results!=null){
            for (SolrDocument result : results) {
                System.out.println("======id=====" + result.get("id"));
                System.out.println("=====product_name======" + result.get("product_name"));
                System.out.println("======product_catalog_name=====" + result.get("product_catalog_name"));
                System.out.println("=======product_price====" + result.get("product_price"));
                System.out.println("=================================================================");
            }
        }
    }
}
