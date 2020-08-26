package com.dbl.simple;

import com.dbl.simple.base.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * descrription:
 * <p>
 * Create by DbL on 2020/8/26 0026 23:47
 */
@SpringBootTest
public class WeatherTest {
    @Autowired
    WeatherService weatherService;

    @Test
    public void getWeatherTest() {
        System.out.println(weatherService.GetWeatherData("忠县"));
    }
}




