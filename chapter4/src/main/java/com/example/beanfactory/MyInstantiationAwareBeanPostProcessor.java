package com.example.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by heyao on 2017/3/14.
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    //实例化bean前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor postProcessBeforeInitialization()");
        }
        return null;
    }

    //实例化bean后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor postProcessAfterInstantiation()");
        }
        return true;
    }

    //设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor postProcessPropertyValues()");
        }
        return pvs;
    }
}
