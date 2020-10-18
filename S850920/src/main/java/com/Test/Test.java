package com.Test;

import com.pojo.Dep;
import com.pojo.Emp;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test extends TestCase {

    public void _testInsert() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Dep dep = new Dep();
        dep.setDepName("供销科");

        int n = sqlSession.insert("com.pojo.Dep.insert" , dep);
        System.out.println(n);
        sqlSession.commit();
        sqlSession.close();
    }

    public void testInsert() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Dep dep = new Dep();
        dep.setDepName("会籍部1");

        int n = sqlSession.insert("com.pojo.Dep.insert" , dep);

        Emp emp = new Emp();
        emp.setEmpId(dep.getDepId());
        emp.setEmpName("小王");
        int x = sqlSession.insert("com.pojo.Emp.insertEmp" , emp);

        sqlSession.commit();
        sqlSession.close();

    }
}
