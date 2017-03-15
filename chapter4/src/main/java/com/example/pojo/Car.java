package com.example.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by heyao on 2017/3/13.
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("调用 Car()构造函数");
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用 Car.setBrand()设置属性");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    //BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("调用 BeanFactoryAware.setBeanFactory()");
    }

    //BeanNameAware接口方法
    public void setBeanName(String s) {
        this.beanName = s;
        System.out.println("调用 BeanNameAware.setBeanName()设置属性");
    }

    //DisposableBean接口方法
    public void destroy() throws Exception {
        System.out.println("调用 DisposableBean.destroy()");
    }

    //InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用 InitializingBean.afterPropertiesSet()");
    }

    //通过<bean>的init-method属性指定的方法
    public void myInit() {
        System.out.println("通过<bean>的init-method属性指定    myInit()");
    }

    //通过<bean>的destroy-method属性指定的方法
    public void myDestroy() {
        System.out.println("通过<bean>的destroy-method属性指定     myDestroy()");
    }
}
