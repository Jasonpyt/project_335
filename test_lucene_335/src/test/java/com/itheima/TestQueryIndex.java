package com.itheima;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;

/**
 * 查询索引
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestQueryIndex {

    @Test
    public void test() throws Exception {
        //创建分词器对象，查询和修改，删除时使用的分词器对象必须与创建索引库使用的分词器一致
        Analyzer analyzer = new StandardAnalyzer();
        //索引库位置对象
        FSDirectory directory = FSDirectory.open(new File("e:/dic"));
        //创建输入流对象
        IndexReader reader = IndexReader.open(directory);
        //索引查询对象
        //参数：输入流对象
        IndexSearcher indexSearcher = new IndexSearcher(reader);
        //查询解析对象
        //参数1:指定默认查询的域名
        //参数2：分词器对象
        QueryParser queryParser = new QueryParser("name",analyzer);
        //创建查询对象
        //参数：查询的关键字
        Query query = queryParser.parse("description:java");
        //查询操作
        //参数1：查询对象
        //参数2：查询的最大条数
        //返回值：返回符合条件的上面的文档
        TopDocs topDocs = indexSearcher.search(query, 10);
        //返回分数文档
        ScoreDoc[] scoreDocs =  topDocs.scoreDocs;
        //遍历数组
        for (ScoreDoc scoreDoc : scoreDocs) {
            //返回的是符合条件的文档的id
            int docId = scoreDoc.doc;
            //查询真正的文档对象
            Document doc = indexSearcher.doc(docId);
            //根据域名获取文档对象的值
            String id = doc.get("id");
            System.out.println(id);
            String name = doc.get("name");
            System.out.println(name);
            String pic = doc.get("pic");
            System.out.println(pic);
            String price = doc.get("price");
            System.out.println(price);
            String description = doc.get("description");
            System.out.println(description);
        }
        reader.close();
    }

}
