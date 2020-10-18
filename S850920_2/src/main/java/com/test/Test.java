package com.test;

import com.mapper.DepMapper;
import com.pojo.Dep;
import com.pojo.Emp;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test extends TestCase {

    public void _testFind() throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSessionFactory.getConfiguration().addMapper(DepMapper.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepMapper depMapper = sqlSession.getMapper(DepMapper.class);
        System.out.println(depMapper.getClass());
        List<Dep> list = depMapper.findall();
    }

    public void _testFindId() throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSessionFactory.getConfiguration().addMapper(DepMapper.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepMapper depMapper = sqlSession.getMapper(DepMapper.class);
        List<Dep> list = depMapper.findId(1);
        for (Dep dep : list){
            System.out.println(dep.getDepId() + "\t" + dep.getDepName());
        }
    }

    public void testFindEmp() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSessionFactory.getConfiguration().addMapper(DepMapper.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepMapper depMapper = sqlSession.getMapper(DepMapper.class);
        List<Emp> list = depMapper.findEmp(103,"阿斯顿");
        for (Emp e : list) {
            System.out.println(e.getEmpId() +"\t"+e.getEmpName());
        }
    }

}
