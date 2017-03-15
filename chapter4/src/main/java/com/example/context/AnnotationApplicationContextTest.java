package com.example.context;

import com.example.pojo.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * Created by heyao on 2017/3/13.
 */
public class AnnotationApplicationContextTest {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        Car car = context.getBean("car", Car.class);
        System.out.println(car.toString());

        GenericGroovyApplicationContext applicationContext = new GenericGroovyApplicationContext("classpath:com/example/beanfactory/groovy-beans.groovy");
        Car car1 = (Car) applicationContext.getBean("car");
        System.out.println(car1.toString());

    }
}
