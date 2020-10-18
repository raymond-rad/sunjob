package com.test;

import com.ioc.ApplicationContext;
import com.pojo.Student;
import junit.framework.TestCase;

public class Test extends TestCase {

    public void testGetInstance(){
        Student student = (Student) ApplicationContext.getInstance("Student");
        student.setSid(1);
        System.out.println(student.getSid());
    }
}
