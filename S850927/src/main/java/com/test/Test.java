package com.test;

import com.pojo.Dep;
import com.pojo.Emp;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Set;

public class Test extends TestCase {
    public void _testFindbyid() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        Dep dep = sqlSession.selectOne("com.pojo.Dep.findbyid",1);
        Set<Emp> emps = dep.getEmps();
        for (Emp emp : emps) {
            System.out.println(emp.getEmpId()+"\t"+emp.getEmpName());
        }

    }

    public void _testFind() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        Dep dep = sqlSession.selectOne("com.pojo.Dep.find",2);
        System.out.println(dep.getDepId()+"\t"+dep.getDepName());
        Set<Emp> emps = dep.getEmps();
        for (Emp emp : emps) {
            System.out.println(emp.getEmpId()+"\t"+emp.getEmpName());
        }
    }

    public void _testFindEmp() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        Emp emp = sqlSession.selectOne("com.pojo.Emp.findbyid",102);
        System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getDid());
        Dep dep = emp.getDep();
        System.out.println(dep.getDepId()+"\t"+dep.getDepName());
    }

    public void testFind2() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession =  sqlSessionFactory.openSession();

        Emp emp = sqlSession.selectOne("com.pojo.Emp.find",102);
        System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getDid());
        Dep dep = emp.getDep();
        System.out.println(dep.getDepId()+"\t"+dep.getDepName());
    }
}
