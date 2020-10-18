package com.test;

import com.pojo.Dep;
import com.service.DepService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app*.xml");
        DepService depService = (DepService) applicationContext.getBean("depService");

        Dep dep = new Dep();
        dep.setDepId(9);
        dep.setDepName("消防部");
        depService.add(dep);
    }
}
