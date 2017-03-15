package com.example.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by heyao on 2017/3/14.
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    //对car <bean>的brand属性配置信息进行"偷梁换柱"的加工操作
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("car");
        beanDefinition.getPropertyValues().addPropertyValue("brand","奇瑞QQ");
        System.out.println("BeanFactoryPostProcessor.postProcessBeanFactory() !");
    }
}
