package com.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class ApplicationContext {

    public static Object getInstance(String id){
        SAXReader saxReader = new SAXReader();
        Object o = null;

        try {
            Document document = saxReader.read(ApplicationContext.class.getResourceAsStream("/Student.xml"));
            Element element = (Element) document.selectSingleNode("beans/bean[@id='"+id+"']" );
            String classname = element.attribute("class").getValue();
            Class c = Class.forName(classname);

            o = c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return o;
    }
}
