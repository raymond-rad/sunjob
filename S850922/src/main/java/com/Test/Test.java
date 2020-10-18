package com.Test;

import com.pojo.Dep;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Test extends TestCase {

    public void _testAdd() throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Dep dep = new Dep();
        dep.setDepName("消息部");

        Dep dep1 = new Dep();
        dep1.setDepName("小石堡");

        Dep dep2 = new Dep();
        dep2.setDepName("大城堡");

        List<Dep> list = new ArrayList<Dep>();
        list.add(dep);
        list.add(dep1);
        list.add(dep2);

        sqlSession.insert("com.pojo.Dep.add",list);

        sqlSession.commit();
        sqlSession.close();
    }

    public void _testUpdate() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Dep dep = new Dep();
        dep.setDepId(1);
        dep.setDepName("人事部");

        sqlSession.update("com.pojo.Dep.update",dep);
        sqlSession.commit();
        sqlSession.close();
    }

    public void _testUpdates() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Dep dep = new Dep();
        dep.setDepId(1);
        dep.setDepName("人事部");

        sqlSession.update("com.pojo.Dep.update1",dep);
        sqlSession.commit();
        sqlSession.close();
    }

    public void testSelect() throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();



        List<Dep> list = sqlSession.selectList("com.pojo.Dep.select");

        for (Dep d : list){
            System.out.println(d.getDepId() + "\t" + d.getDepName());
        }
        sqlSession.commit();
        sqlSession.close();
    }




}
