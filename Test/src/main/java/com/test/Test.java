package com.test;

import com.mapper.EmpMapper;
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

    public void testFindAll() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSessionFactory.getConfiguration().addMapper(EmpMapper.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = empMapper.findAll();
        for (Emp e : list) {
            System.out.println(e.getEmpId() +"\t"+e.getEmpName());
        }
    }
}
