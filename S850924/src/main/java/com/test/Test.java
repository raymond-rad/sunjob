package com.test;

import com.pojo.Dep;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.List;

public class Test extends TestCase {

    public void _testChoose() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();


        Dep dep = new Dep();
        dep.setDepName("销售部");

        List<Dep> list = sqlSession.selectList("com.pojo.Dep.select",dep);
        for (Dep d : list){
            System.out.println(d.getDepId() +"\t"+d.getDepName());
        }
    }

    public void _testH(){
        Connection connection1 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sunjob","root","root");
            String sql = "call aaaa()";
            CallableStatement callableStatement = connection1.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1) + rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void _testFind(){
        Connection connection1 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sunjob","root","root");
            String sql = "call find(?)";
            CallableStatement callableStatement = connection1.prepareCall(sql);
            callableStatement.setObject(1,2);
            ResultSet rs = callableStatement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void testF(){
        Connection connection1 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sunjob","root","root");
            String sql = "call bb(?,?,?)";
            CallableStatement callableStatement = connection1.prepareCall(sql);
            callableStatement.setObject(1,1);
            callableStatement.setObject(2,5);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            int  rs = callableStatement.executeUpdate();
            int s = callableStatement.getInt(3);
            System.out.println(s);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
