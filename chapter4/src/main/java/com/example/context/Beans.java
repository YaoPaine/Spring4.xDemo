package com.example.context;

import com.example.pojo.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by heyao on 2017/3/13.
 */
@Configuration
public class Beans {

    @Bean(name = "car")
    public Car buildCar(){
        Car car = new Car();
        car.setBrand("Land Rover");
        car.setMaxSpeed(120);
        return car;
    }
}
