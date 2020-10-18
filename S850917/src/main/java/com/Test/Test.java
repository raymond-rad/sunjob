package com.Test;

import com.pojo.Dep;
import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class Test  extends TestCase {

    public void _testFindId() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();


        List<Dep> list = sqlSession.selectList("com.pojo.Dep.findId");

        for (Dep dep : list) {
            System.out.println(dep.getDepId()+"\t"+dep.getDepName());
        }
        sqlSession.close();
    }

    public void testInsert() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Dep dep = new Dep();
        dep.setDepId(3);
        dep.setDepName("物流部");
        int n = sqlSession.insert("com.pojo.Dep.insert",dep);
        System.out.println(n);

        sqlSession.commit();
        sqlSession.close();




    }
}
