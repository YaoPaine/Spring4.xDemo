package com.example.beanfactory;

import com.example.pojo.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by heyao on 2017/3/14.
 */
public class BeanLifeCycle {


    public static void main(String[] args) {
        lifeCycleInBeanFactory();
    }

    private static void lifeCycleInBeanFactory() {
        //1、装载配置文件并启动容器
        Resource resource = new ClassPathResource("beans.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);

        //向容器中注册MyBeanPostProcessor 后处理器
        beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());

        //向容器注册MyInstantiationAwareBeanPostProcessor 后处理器
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //第一次从容器中获取Car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用
        Car car1 = (Car) beanFactory.getBean("car");
        System.out.println(car1.toString());

        car1.setColor("红色");

        //第二次从容器中获取Car，直接从缓存池获取
        Car car2 = (Car) beanFactory.getBean("car");
        System.out.println("car1 == car2：" + (car1 == car2));

        //关闭缓存池
        beanFactory.destroySingletons();

    }
}
