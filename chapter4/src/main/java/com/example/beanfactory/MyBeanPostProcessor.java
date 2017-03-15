package com.example.beanfactory;

import com.example.pojo.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by heyao on 2017/3/14.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

        if ("car".equals(s)) {
            Car car = (Car) o;
            if (car.getColor() == null) {
                System.out.println("BeanPostProcessor.postProcessBeforeInitialization(),color为空，设置为red");
                car.setColor("red");
            }
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {

        if ("car".equals(s)) {
            Car car = (Car) o;
            if (car.getMaxSpeed() >= 200) {
                System.out.println("BeanPostProcessor.postProcessAfterInitialization(),将maxSpeed调整为200");
                car.setMaxSpeed(200);
            }
        }
        return o;
    }
}
