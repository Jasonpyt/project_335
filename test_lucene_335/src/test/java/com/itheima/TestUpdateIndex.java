package com.itheima;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
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
public class TestUpdateIndex {

    @Test
    public void test() throws Exception {
        // 分词器对象
        Analyzer analyzer = new StandardAnalyzer();
        // 要被修改的对象: 要查询到被修改的文档对象
        //创建分词对象
        //参数1： 要修改域  参数2：要修改的域的数据
        Term term = new Term("id","1");
        // 修改后的文档对象
        Document doc = new Document();
        TextField idField = new TextField("id",String.valueOf(6), Field.Store.YES);
        TextField nameField = new TextField("name","西游记", Field.Store.YES);
        TextField picField = new TextField("pic","12312421412.jpg", Field.Store.YES);
        TextField priceField = new TextField("price","18.8", Field.Store.YES);
        TextField descriptionField = new TextField("description","一个猪和一个猴的故事", Field.Store.YES);

        doc.add(idField);
        doc.add(nameField);
        doc.add(picField);
        doc.add(priceField);
        doc.add(descriptionField);

        //索引库的位置对象
        FSDirectory directory = FSDirectory.open(new File("f:/dic"));
        //创建输出流配置对象
        //参数1：版本号
        //参数2：分词器对象
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        // 输出流对象
        /**
         * 参数1：位置对象
         * 参数2：输出流配置对象
         */
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        //开始修改
        //参数1：输入的信息
        //参数2： 要修改后的文档对象
        //结果：保留原来对象的索引，删除原来的文档，添加了一个新的文档对象
        indexWriter.updateDocument(term, doc);
        //提交
        indexWriter.commit();
        //关闭
        indexWriter.close();

    }
}
