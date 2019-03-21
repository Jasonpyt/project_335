package com.itheima;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestDeleteIndex {

    @Test
    public void test() throws Exception {
        //输入关键字
        //创建词元对象: 参数1：域名  参数2：域值
        Term term = new Term("id","2");

        //索引库的位置
        FSDirectory directory = FSDirectory.open(new File("f:/dic"));
        //分词器对象
        Analyzer analyzer  =new StandardAnalyzer();

        //创建输出流配置对象
        //参数1：版本号
        //参数2：分词器
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);
        // 输出流对象
        //参数1：位置对象
        //参数2： 输出流配置对象
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        //指定条件删除操作：结果：保留索引，删除文档对象
//        indexWriter.deleteDocuments(term);
        //删除所有:索引和文档全部删除
        indexWriter.deleteAll();
        //提交
        indexWriter.commit();
        //关闭流
        indexWriter.close();
    }
}
