package com.test.solr;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;


/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/2/16
 */
public class TestManager {
    @Test
    public void testCreateAndUpdate() throws Exception {
        //1. 创建和solr服务器的连接
        //http://192.168.200.128:8080/solr连接solr默认实例也就是collection1实例
        //http://192.168.200.128:8080/solr/实例名称例如collection3
        SolrServer solrServer = new HttpSolrServer("http://192.168.200.128:8080/solr");
        for (int i = 100; i > 0; i--) {
            //2. 创建文档对象
            SolrInputDocument doc = new SolrInputDocument();
            //3. 在文档对象中加入域对象
            doc.addField("id", i);
            doc.addField("product_name", "三星手机" + i);
            doc.addField("product_catalog_name", "手机");
            doc.addField("product_price", i);
            doc.addField("product_picture", "xxxxx.jpg");
            //4. 将文档对象加入到solr索引库中
            solrServer.add(doc);
            //5. 提交
            solrServer.commit();
        }
    }

    @Test
    public void testDelete() throws Exception {
        //1. 创建和solr服务器的连接
        //http://192.168.200.128:8080/solr连接solr默认实例也就是collection1实例
        //http://192.168.200.128:8080/solr/实例名称例如collection3
        SolrServer solrServer = new HttpSolrServer("http://192.168.200.128:8080/solr");
        //根据id删除
//        solrServer.deleteById("1");
        //根据查询条件删除, 这里是删除所有
        solrServer.deleteById("*:*");
        //提交
        solrServer.commit();
    }
}
