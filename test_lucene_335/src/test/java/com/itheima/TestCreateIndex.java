package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestCreateIndex {

    @Test
    public void createIndex() throws Exception {
        // 查询所有的数据
        BookDao bookDao = new BookDao();
        List<Book> bookList = bookDao.findAll();
        // 创建文档对象
        //创建文档的集合
        List<Document> docList = new ArrayList<>();

        for (Book book : bookList) {
            //一条数据对应一个文档对象，一个book就应该有一个文档
            //创建一个文档对象, 包含book数据
            Document doc = new Document();
            //一个属性对应一个域对象
            //参数1： 域名，一般是列名
            //参数2： 域中的值，列对应的值
            //参数3： 是否存储，是否在索引库中存储域中的内容 -- 暂时设定存储
//            TextField idField = new TextField("id", String.valueOf(book.getId()) , Field.Store.YES);
//            TextField nameField = new TextField("name",book.getName(), Field.Store.YES);
//            TextField picField = new TextField("pic",book.getPic(), Field.Store.YES);
//            TextField priceField = new TextField("price",String.valueOf(book.getPrice()), Field.Store.YES);
//            TextField descriptionField = new TextField("description",book.getDescription(), Field.Store.YES);
            /**
             * id:
                 * 是否分词: 否
                 * 是否索引: 是
                 * 是否存储: 是
             */
            StringField idField = new StringField("id", String.valueOf(book.getId()), Field.Store.YES);
            /**
             * name:
             * 是否分词: 是
             * 是否索引: 是
             * 是否存储: 是
             */
            TextField nameField = new TextField("name",book.getName(), Field.Store.YES);
            /**
             * pic :
             * 是否分词: 否
             * 是否索引: 否
             * 是否存储: 是
             */
            StoredField picField = new StoredField("pic", book.getPic());
            /**
             * price :
             * 是否分词: 是
             * 是否索引: 是
             * 是否存储: 是
             */
            TextField priceField = new TextField("price",String.valueOf(book.getPrice()), Field.Store.YES);
            /**
             * description  :
             * 是否分词: 是
             * 是否索引: 是
             * 是否存储: 否
             */
            TextField descriptionField = new TextField("description",book.getDescription(), Field.Store.NO);

            //把域添加到文档中
            doc.add(idField);
            doc.add(nameField);
            doc.add(picField);
            doc.add(priceField);
            doc.add(descriptionField);
            //添加到集合中
            docList.add(doc);
        }

        // 创建分词器对象：切分词过程
        // lucene自带分词器对象：对中文不太友好，认为一个字就是一个词
//        Analyzer analyzer = new StandardAnalyzer();
        //创建中文分词器对象
        Analyzer analyzer = new IKAnalyzer();
        // 指定索引库的位置
        FSDirectory directory = FSDirectory.open(new File("e:/dic"));
        //创建索引输出流配置对象
        /**
         * 参数1： 版本号
         * 参数2： 分词器对象
         */
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        // 创建索引输出流对象
        //参数1： 索引库的位置对象
        //参数2：索引输出流配置对象
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

        //把文档对象写入到索引库中
        for (Document doc : docList) {
            indexWriter.addDocument(doc);
        }
        //提交
        indexWriter.commit();
        //关闭流
        indexWriter.close();
    }
}
