package com.service;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password1");
        String password1 = req.getParameter("password2");

        if (!password.equals(password1)){
            System.out.println("两次密码输入不正确");
        }else {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sunjob", "root", "root");

                String sql = "insert into  users(user,password) values (?,?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setObject(1,username);
                ps.setObject(2,password);
                int n = ps.executeUpdate();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
