package com.example.test;

import com.example.pojo.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * Created by heyao on 2017/3/13.
 */

public class BeanFactoryTest {

    public static void main(String[] args) {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:com/example/beanfactory/beans.xml");
        try {
            System.out.println(resource.getURL());
        } catch (IOException e) {
            e.printStackTrace();
        }

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);

        System.out.println("init BeanFactory.");
        Car car = factory.getBean("car1", Car.class);
        System.out.println("car bean is ready for use!");
        System.out.println(car.toString());
    }
}
